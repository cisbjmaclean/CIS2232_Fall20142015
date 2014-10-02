package controller;

import forms.PinForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import util.Pin;


/**
 * Controller for the Hello
 *
 * @author bjmaclean
 */
public class StudentInformationController extends SimpleFormController {

//    private HelloService helloService;

//    public void setHelloService(HelloService helloService) {
//        this.helloService = helloService;
//    }
    
    
    public StudentInformationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(PinForm.class);
        setCommandName("studentInformation");
        setSuccessView("success");
        setFormView("studentInformation");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        PinForm pinForm = (PinForm) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        if(Pin.validatePin(pinForm.getCourseName(), pinForm.getPin()))
            return mv;
        else
            return new ModelAndView("fail");
            
        //mv.addObject("helloMessage", helloService.sayHello(PinForm.getValue()));
    }
}
