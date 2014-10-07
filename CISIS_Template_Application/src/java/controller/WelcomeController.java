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
@RequestMapping("/welcome.htm")
public class WelcomeController { 

    private Menu menu;

    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(ModelMap model) {
        this.menu = new Menu();
        menu.setAction("test");
        model.addAttribute("menu", menu);
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu) {
        System.out.println("The form was submitted and the action was ***" + menu.getAction()+ "***");
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("login", new Login());
        return mv;
    }
}

