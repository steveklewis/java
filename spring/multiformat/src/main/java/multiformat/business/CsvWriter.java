package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class CsvWriter implements IWriter {
    
    StringBuilder sbHeaders = new StringBuilder();
    StringBuilder sbValues = new StringBuilder();
    
    public void write(Field[] fields, Field field, Object bean, int i, boolean embedded)
            throws IllegalAccessException {
        sbHeaders.append(field.getName());
        sbValues.append(field.get(bean));
        if (i < fields.length - 1 || embedded) {
            sbHeaders.append(",");
            sbValues.append(",");
        }
    }
    
    public String toString() {
        return sbHeaders.toString() + "\n" + sbValues.toString();
    }
}
