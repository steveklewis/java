package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public interface IWriter {
    public void write(Field field, Object bean, boolean lastField, boolean embedded)
            throws IllegalAccessException;
    
    public String toString();
}
