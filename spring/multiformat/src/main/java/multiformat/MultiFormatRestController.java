package multiformat;

import java.io.StringWriter;
import multiformat.business.BeanExporter;
import multiformat.business.IDataExporter;
import multiformat.exporters.DataExporterFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author slewis
 */
@RestController
public class MultiFormatRestController {
    @RequestMapping(value="/multiformat", method=RequestMethod.POST)
    public String multiformatSubmit(@ModelAttribute TestInputBean input, Model model) {        
        StringWriter sw = new StringWriter();        
        
        DataExporterFactory exportFactory = new DataExporterFactory();
        
        IDataExporter dataExporter = exportFactory.createDataExporter(input.getFormat(), sw);
        if (dataExporter == null) {
            return "Unrecognized format: " + input.getFormat();
        }
        
        BeanExporter beanExporter = new BeanExporter();
        beanExporter.exportBean(dataExporter, input.getType());                        
        dataExporter.finishExporting();
        
        return sw.toString();
    }
}
