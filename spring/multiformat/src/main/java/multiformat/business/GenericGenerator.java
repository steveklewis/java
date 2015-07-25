package multiformat.business;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

/**
 * I noticed that my style changes with every language I use. With python,
 * I try to write pythonically. With C#, I try to use the nice language features
 * that have been there for quite a while, including Select and Where in Linq.
 * With Golang, I try to stay very simple and functional. But with Java my
 * style hasn't kept up, so I'm trying to simplify this code using the new
 * Java 8 Stream features, since I've used similar features in other languages.
 * 
 * @author slewis
 */
public class GenericGenerator {

    public boolean embeddedField(Field f) {
        Class type = f.getType();
        return !(type.equals(String.class)
                || type.equals(Date.class)
                || type.isPrimitive());
    }

    public void writeFields(Class clazz, IWriter writer)
            throws IllegalAccessException, InstantiationException {
        Object topBean = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        Field lastField = Arrays.stream(fields).reduce((a, b) -> b).orElse(null);

        if (lastField == null) {
            return;
        }

        // Make all fields accessible
        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);
        });

        // Take care of non-embedded fields
        Arrays.stream(fields).filter(f1 -> !embeddedField(f1)).forEach(f2 -> {
            try {
                System.out.println(f2.getName());
                writer.write(f2, topBean, f2.equals(lastField), false);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

        // Take care of embedded fields
        Arrays.stream(fields).filter(f1 -> embeddedField(f1)).forEach(f2 -> {
            Class embeddedClass = f2.getType();
            Object embeddedBean;
            try {
                embeddedBean = embeddedClass.newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
                return;
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
                return;
            }

            Field[] embeddedFields = embeddedClass.getDeclaredFields();
            Field lastEmbeddedField = Arrays.stream(embeddedFields).reduce((a, b) -> b).orElse(null);
            
            // Set embedded fields to accessible
            Arrays.stream(embeddedFields).forEach(ef -> {
                ef.setAccessible(true);
            });
            
            Arrays.stream(embeddedFields).forEach(ef -> {
                try {
                    writer.write(ef, embeddedBean, ef.equals(lastEmbeddedField), true);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            });
            
        });
    }

}
