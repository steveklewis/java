package multiformat;

import multiformat.business.GenericGenerator;
import multiformat.business.IWriter;
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
        
        Class modelClass = Class.forName("multiformat.models.Test" + input.getType() +  "Bean");
        Class outputClass = Class.forName("multiformat.business." + input.getFormat() + "Writer");
        
        IWriter writer = (IWriter) outputClass.newInstance();
        
        gen.writeFields(modelClass, (IWriter) writer);
        return writer.toString();
    }
}
