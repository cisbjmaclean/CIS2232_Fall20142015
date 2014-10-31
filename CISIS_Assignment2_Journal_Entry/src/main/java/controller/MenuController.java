package controller;

import beans.CodeValue;
import fitness.Journal;
import fitness.JournalEntry;
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
        
        /* If the user chooses to add a journal entry, send them to the 
           addJournal mv.  
         */
        } else if (menu.getAction().equalsIgnoreCase("Add Journal Entry")) {
            System.out.println("User wants to ad a journal entry");
            mv = new ModelAndView("addJournal");
            mv.addObject("journalEntry", new JournalEntry());
            
        /* If the user chooses to view journal entries, send them to the 
           viewJournalEntries view. Make sure that the journal entries are loaded
           into the mv before returning.
         */        
        } else if (menu.getAction().equalsIgnoreCase("View Journal Entries")) {
            System.out.println("User wants to view the entries");
            mv = new ModelAndView("viewJournalEntries");
            Journal journal = new Journal();
            journal.loadEntries();
            mv.addObject("message","Here are the entries");
            mv.addObject("journal", journal.getJournal());
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
