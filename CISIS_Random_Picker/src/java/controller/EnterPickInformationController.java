package controller;

import forms.Login;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.RandomPick;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("enterPickInformation")
public class EnterPickInformationController {

//    private RandomPick randomPick;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("randomPick") RandomPick randomPick) {
        System.out.println("The form was submitted and the course name was ***" + randomPick.getCourseName() + "***");

        ModelAndView mv = new ModelAndView("main");
        String message = String.valueOf(randomPick.getRandomPick());
        mv.addObject("message", message);
        mv.addObject("randomPick",randomPick);

        
        return mv;
    }
}
