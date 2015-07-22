package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class JsonWriter implements IWriter {
    
    
    public String json = "{";
    
    
    
    @Override
    public void write(Field[] fields, Field field, Object bean, int i, boolean embedded)
            throws IllegalAccessException {
        json += "\"" + field.getName() + "\":\"" + field.get(bean) + "\"";
        if (i < fields.length - 1 || embedded) {
            json += ",";            
        }        
    }
    
        
    public String toString() {
        return json + "}";
    }
}
