package controller;

import forms.Login;
import forms.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private Login login;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***" + login.getUsername() + "***");

        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        if (login.getUsername().equalsIgnoreCase("TEST")
                && login.getPassword().equalsIgnoreCase("TEST")) {
            mv = new ModelAndView("main");

        } else {
            mv = new ModelAndView("login");
            Menu temp = new Menu();
            temp.setAction("Back from login");
            mv.addObject("menu", temp);

        }

        return mv;
    }
}
