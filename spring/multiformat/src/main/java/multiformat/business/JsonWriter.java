package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class JsonWriter implements IWriter {
    
    
    public String json = "{";
    
    
    
    @Override
    public void write(Field field, Object bean, boolean lastField, boolean embedded)
            throws IllegalAccessException {
        json += "\"" + field.getName() + "\":\"" + field.get(bean) + "\"";
        if (!lastField || embedded) {
            json += ",";            
        }        
    }
    
        
    public String toString() {
        return json + "}";
    }
}
