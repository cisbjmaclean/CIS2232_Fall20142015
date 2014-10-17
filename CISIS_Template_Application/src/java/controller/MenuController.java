package controller;

import beans.CodeValue;
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
@RequestMapping("menu")
public class MenuController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu) {
        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        if (menu.getAction().equalsIgnoreCase("Logout")) {
            mv = new ModelAndView("welcome");
        } else if (menu.getAction().equalsIgnoreCase("View Provinces")) {
            System.out.println("User wants to view the provinces");
            mv = new ModelAndView("main");
            mv.addObject("message", "User selected View Provinces");
        } else if (menu.getAction().equalsIgnoreCase("View Countries")) {
            System.out.println("User wants to view the countries");
            mv = new ModelAndView("viewCountries");
            mv.addObject("message", "User selected View Countries");
        } else if (menu.getAction().equalsIgnoreCase("View Codes")) {
            System.out.println("User wants to view the codes");
            mv = new ModelAndView("viewCodes");
            mv.addObject("message", "User selected view codes");
            mv.addObject("codeValue", new CodeValue());
        } else {
            mv = new ModelAndView("welcome");
        }

        return mv;
    }
}
