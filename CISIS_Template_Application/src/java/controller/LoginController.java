package controller;

import forms.Login;
import forms.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("/login.htm")
public class LoginController { 

    private Login login;

    @RequestMapping(method = RequestMethod.GET)
    public String loadInformation(ModelMap model) {
        this.login = new Login();
        model.addAttribute("login", login);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***" + login.getUsername()+ "***");
        System.out.println("--> The password was ***" + login.getPassword()+ "***");
        return "welcome";

    }
}

