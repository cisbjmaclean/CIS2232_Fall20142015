package controller;

import forms.Menu;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller for the Hello
 *
 * @author bjmaclean
 */
public class MenuController extends SimpleFormController {

//    private HelloService helloService;
//    public void setHelloService(HelloService helloService) {
//        this.helloService = helloService;
//    }
    public MenuController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Menu.class);
        setCommandName("menu");
        setSuccessView("welcome");
        setFormView("welcome");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        return mv;
    }
}
