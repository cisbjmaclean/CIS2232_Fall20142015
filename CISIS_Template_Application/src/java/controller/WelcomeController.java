package controller;

import forms.Menu;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller for the Hello
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("/welcome.htm")
public class WelcomeController {//extends SimpleFormController {

//    private HelloService helloService;
//    public void setHelloService(HelloService helloService) {
//        this.helloService = helloService;
//    }
    private Menu menu;



//    public void setMenuForm(Menu menuform) {
//        this.menuForm = menuform;
//    }
//    @Autowired
//    public void setMenu(Menu menuForm) {
//        this.menu = menuForm;
//    }
//
//    public WelcomeController() {
//        //Initialize controller properties here or 
//        //in the Web Application Context
//
//        setCommandClass(Menu.class);
//        setCommandName("menuForm");
//        setSuccessView("welcome");
//        setFormView("welcome");
//    }

//    	@Override
//	protected Map referenceData(HttpServletRequest request) throws Exception {
//		Map referenceData = new HashMap();
//		referenceData.put("menuForm", new Menu());
//		return referenceData;
//	}
//    @Override
//    protected Object formBackingObject(HttpServletRequest request)
//            throws Exception {
//
//        Menu temp = new Menu();
//        temp.setAction("test");
//        //request.setAttribute("menuForm", temp);
//        return temp;
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(ModelMap model) {
        this.menu = new Menu();
        menu.setAction("test");
        model.addAttribute("menu", menu);
        return "welcome";
    }
//
//    @Autowired
//    public void setMenuForm(Menu menu) {
//        this.menuForm = new Menu();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("menu") Menu menu) {
        System.out.println(""
                + "test output");
        System.out.println("action" + menu.getAction());
        return "welcome";

    }
//    //Use onSubmit instead of doSubmitAction 
//    //when you need access to the Request, Response, or BindException objects
//    @Override
//    protected ModelAndView onSubmit(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object command,
//            BindException errors) throws Exception {
//        Menu form = (Menu) command;
//        System.out.println("form action=" + form.getAction());
//        ModelAndView mv = new ModelAndView(getSuccessView());
//        return mv;
//
//        //mv.addObject("helloMessage", helloService.sayHello(PinForm.getValue()));
//    }
}

//package controller;
//
//import forms.Menu;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.validation.BindException;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.SimpleFormController;
//
///**
// * Controller for the Hello
// *
// * @author bjmaclean
// */
//public class WelcomeController extends SimpleFormController {
//
////    private HelloService helloService;
////    public void setHelloService(HelloService helloService) {
////        this.helloService = helloService;
////    }
//    public WelcomeController() {
//        //Initialize controller properties here or 
//        //in the Web Application Context
//
//        setCommandClass(Menu.class);
//        setCommandName("menu");
//        setSuccessView("welcome");
//        setFormView("welcome");
//    }
//
//    //Use onSubmit instead of doSubmitAction 
//    //when you need access to the Request, Response, or BindException objects
//    @Override
//    protected ModelAndView onSubmit(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object command,
//            BindException errors) throws Exception {
//        ModelAndView mv = new ModelAndView(getSuccessView());
//        Menu menuForm = (Menu) command;
//        System.out.println("Menu="+menuForm.getAction());
//        return mv;
//    }
//}
