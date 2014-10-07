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
@RequestMapping("/login.htm")
public class LoginControllerBackup { 

    private Login login = new Login();

//    @RequestMapping(method = RequestMethod.GET)
//    public String loadInformation(ModelMap model) {
//        
//        //Create a variable for the login.
//        
//        this.login = new Login();
//        model.addAttribute("login", this.login);
//        return "login";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***"+login.getUsername()+"***");
        ModelAndView mv = new ModelAndView("welcome");
        Menu temp = new Menu();
        temp.setAction("Back from login");
        mv.addObject("menu", temp);
        return mv;
    }
}

