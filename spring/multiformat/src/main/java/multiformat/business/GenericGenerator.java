package multiformat.business;

import java.lang.reflect.Field;

/**
 *
 * @author slewis
 */
public class GenericGenerator {

    public String generateTemplate(Class clazz, IWriter writer)
            throws IllegalAccessException, InstantiationException {
        Object topBean = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);            
            if (field.getType().equals(String.class) ||
                field.getType().equals(java.util.Date.class) ||
                field.getType().isPrimitive()) {
                writer.write(fields, field, topBean, i, false);
            } else {
                Class embeddedClass = field.getType();
                Object embeddedBean = embeddedClass.newInstance();

                Field[] embeddedFields = embeddedClass.getDeclaredFields();                
                for (int j = 0; j < embeddedFields.length; j++) {                    
                    Field embeddedField = embeddedFields[j];
                    embeddedField.setAccessible(true);
                    writer.write(embeddedFields, embeddedField, embeddedBean, j, true);
                }
            }
        }
        return writer.toString();
    }

}
