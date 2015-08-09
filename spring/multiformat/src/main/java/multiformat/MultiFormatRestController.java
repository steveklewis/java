package multiformat;

import multiformat.business.GenericGenerator;
import multiformat.business.IWriter;
import multiformat.business.WriterFactory;
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
    public String multiformatSubmit(@ModelAttribute TestInputBean input, Model model) throws Exception {
        
        GenericGenerator gen = new GenericGenerator();
        
        Class modelClass = BeanFactory.getBeanClass(input.getType());        
        IWriter writer = WriterFactory.createWriter(input.getFormat());
        
        gen.writeFields(modelClass, writer);
        return writer.toString();
    }
}
