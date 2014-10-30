package controller;

import fitness.Journal;
import fitness.JournalEntry;
import java.util.ArrayList;
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
@RequestMapping("addJournalEntry")
public class AddJournalEntryController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("journalEntry") JournalEntry journalEntry) {
        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        mv = new ModelAndView("viewJournalEntries");
        
        Journal journal = new Journal();
        journal.loadEntries();
        journal.add(journalEntry);        
        journal.writeToFile();
        
        System.out.println("Added a journal entry to the journal.");
        mv.addObject("message","Journal entry was added");
        mv.addObject("journal", journal.getJournal());
        
        return mv;
    }
}
