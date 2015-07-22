package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public interface IWriter {
    public void write(Field[] fields, Field field, Object bean, int i, boolean embedded)
            throws IllegalAccessException;
    
    public String toString();
}
