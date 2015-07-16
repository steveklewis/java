package multiformat;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MultiFormatController {

    @RequestMapping(value="/multiformat", method=RequestMethod.GET)
    public String multiformatForm(Model model) {
        model.addAttribute("input", new TestInputBean());
        return "multiformat";
    }
}
