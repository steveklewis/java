package multiformat;

import multiformat.business.GenericGenerator;
import multiformat.business.IWriter;
import multiformat.business.WriterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MultiFormatController {

    @RequestMapping(value="/multiformat", method=RequestMethod.GET)
    public String multiformatForm(Model model) {
        model.addAttribute("input", new TestInputBean());
        return "multiformat";
    }
    
    @RequestMapping(value="/multiformat", method=RequestMethod.POST, produces={"application/json", "application/xml"})
    public @ResponseBody Object multiformatSubmit(@ModelAttribute TestInputBean input, Model model) throws Exception {
//        GenericGenerator gen = new GenericGenerator();
//        
//        Class modelClass = BeanFactory.getBeanClass(input.getType());        
//        IWriter writer = WriterFactory.createWriter(input.getFormat());
        
        //gen.writeFields(modelClass, writer);
        //return writer.toString();
        System.out.println(BeanFactory.getBeanInstance(input.getType()));
        return BeanFactory.getBeanInstance(input.getType());
    }
}
