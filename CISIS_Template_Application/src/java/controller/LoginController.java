package controller;

import forms.Login;
import forms.Menu;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;


/**
 * Controller for the Hello
 *
 * @author bjmaclean
 */
@Controller
public class LoginController {

//    public LoginController() {
//        //Initialize controller properties here or 
//        //in the Web Application Context
//
//        setCommandClass(Login.class);
//        setCommandName("login");
//        setSuccessView("welcome");
//        setFormView("login");
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        //model.addAttribute("login", new Login());
        return "login";
    }

    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @RequestMapping(method = RequestMethod.POST)
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        System.out.println("The onSubmit in LoginController was run.");
        ModelAndView mv = new ModelAndView(new RedirectView("welcome.htm"));
        return mv;
            
    }
}
