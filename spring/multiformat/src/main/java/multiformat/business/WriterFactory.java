/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformat.business;

/**
 *
 * @author slewis
 */
public class WriterFactory {
    public static IWriter createWriter(String format) {        
        if ("csv".equalsIgnoreCase(format)) {
            return new CsvWriter();
        } else if ("json".equalsIgnoreCase(format)) {
            return new JsonWriter();
        } else if ("xml".equalsIgnoreCase(format)) {
            return new XmlWriter();
        } else if ("html".equalsIgnoreCase(format)) {
            return new HtmlWriter();
        }
        return null;
    }
}
