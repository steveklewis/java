package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class HtmlWriter implements IWriter {
    
    
    public String html = "<html><table>";
    public String tableHeaders = "<tr>";
    public String tableValues = "<tr>";
    
    
    @Override
    public void write(Field[] fields, Field field, Object bean, int i, boolean embedded)
            throws IllegalAccessException {
        tableHeaders = tableHeaders += "<th>" + field.getName() + "</th>";
        tableValues = tableValues += "<td>" + field.get(bean) + "</td>";
    }
    
        
    public String toString() {
        return html + tableHeaders + tableValues + "</table></html>";
    }
}
