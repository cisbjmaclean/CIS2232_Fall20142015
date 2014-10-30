package controller;

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
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("journalEntry") @Valid JournalEntry journalEntry, BindingResult result) {

        ModelAndView mv;
        // If there are validation errors
        if (result.hasErrors()) {
            mv = new ModelAndView("addJournal");
            mv.addObject("message","The journal entry is invalid");
            mv.addObject("journalEntry",journalEntry);
            return mv;
        }

        //Setup the next model and view
        mv = new ModelAndView("viewJournalEntries");

        //Go get the latest journal entries from the file.  
        Journal journal = new Journal();
        System.out.println("About to reload the entries");
        journal.loadEntries();
        //Add the latest journal entry.
        journal.add(journalEntry);
        journal.writeToFile();

        System.out.println("Added a journal entry to the journal.");
        //Add a message and the latest journal entries back to the mv before returning it.
        //This will ensure that they are available on the jsp.
        mv.addObject("message", "Journal entry was added");
        mv.addObject("journal", journal.getJournal());

        return mv;
    }
}
