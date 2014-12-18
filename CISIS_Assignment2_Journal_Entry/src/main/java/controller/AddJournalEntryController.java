package controller;

import database.JournalEntryDAO;
import fitness.Journal;
import fitness.JournalEntry;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for adding the journal entries.
 *
 * @author bjmaclean
 * @since 20141030
 */
@Controller
@RequestMapping("addJournalEntry")
public class AddJournalEntryController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("journalEntry") @Valid JournalEntry journalEntry, BindingResult result, HttpServletRequest request) {

        ModelAndView mv;
        // If there are validation errors
        // Will have to investigate why the hasErrors is not working.  
        // It works on Glassfish, but not Tomcat.  Some import analysis required.  
        if (result.hasErrors() || journalEntry.getEntry().length()>100 || journalEntry.getEntry().isEmpty() ) {
            System.out.println("There were errors");
            mv = new ModelAndView("addJournal");
            mv.addObject("message","The journal entry is invalid");
            mv.addObject("journalEntry",journalEntry);
            return mv;
        }

        //Setup the next model and view
        mv = new ModelAndView("viewJournalEntries");

        //Go get the latest journal entries from the file.  
        Journal journal = new Journal();
        
        try{
        //try to insert the entry into the database
        JournalEntryDAO.addEntry(journalEntry);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        System.out.println("About to load entries from database.");
        //update the application journal to match the records in the database
        journal.setJournal(JournalEntryDAO.getAllEntries());
        System.out.println("Added a journal entry to the journal.");
        //Add a message and the latest journal entries back to the mv before returning it.
        //This will ensure that they are available on the jsp.
        mv.addObject("message", "Journal entry was added");
        mv.addObject("journal", journal.getJournal());

        return mv;
    }
}
