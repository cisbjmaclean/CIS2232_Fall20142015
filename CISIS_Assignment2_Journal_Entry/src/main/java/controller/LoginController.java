package controller;

import business.AccessBO;
import database.CodeValueDAO;
import database.JournalEntryDAO;
import fitness.Journal;
import forms.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***" + login.getUsername() + "***");

        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        boolean validCredentials = false;
        try {
            validCredentials = AccessBO.validate(login);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (validCredentials) {
            CodeValueDAO.loadCodes(request);
            Journal journal = new Journal();
            //journal.loadEntries();
            journal.setJournal(JournalEntryDAO.getAllEntries());
            mv = new ModelAndView("viewJournalEntries");
            mv.addObject("message", "Here are the entries");
            mv.addObject("journal", journal.getJournal());
        } else {
            mv = new ModelAndView("login");
        }

        return mv;
    }
}
