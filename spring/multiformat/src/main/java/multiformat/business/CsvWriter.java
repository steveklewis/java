package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class CsvWriter implements IWriter {
    
    StringBuilder sbHeaders = new StringBuilder();
    StringBuilder sbValues = new StringBuilder();
    
    public void write(Field field, Object bean, boolean lastField, boolean embedded)
            throws IllegalAccessException {
        sbHeaders.append(field.getName());
        sbValues.append(field.get(bean));
        if (!lastField || embedded) {
            sbHeaders.append(",");
            sbValues.append(",");
        }
    }
    
    public String toString() {
        return sbHeaders.toString() + "\n" + sbValues.toString();
    }
}
