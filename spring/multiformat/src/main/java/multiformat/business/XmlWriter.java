package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class XmlWriter implements IWriter {
   
    public String xml = "<xml>";
  
    
    @Override
    public void write(Field[] fields, Field field, Object bean, int i, boolean embedded)
            throws IllegalAccessException {
        xml = xml += "<" + field.getName() + ">" + field.get(bean) + "</" + field.getName() + ">";        
    }
    
        
    public String toString() {
        return xml + "</xml>";
    }
}
