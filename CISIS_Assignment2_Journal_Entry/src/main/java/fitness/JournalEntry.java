/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.nio.file.*;
import java.util.StringTokenizer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author dmaclean31977
 */
public class JournalEntry {

    //Attributes of a journal entry
    @NotNull
    @Size(min=1, max=100, message="The description must be between {min} and {max} characters.")
    private String entry;
    /*
    * Added entry id for database management purposes.
    *
    * @author Logan Noonan
    * @since 20141203
    */
    private int entryId;
    private String dateOfEntry;
    private String weight;

    public static Path file = Paths.get("C:\\cis2232\\journal.txt");

    /**
     * This constructor will create a journal entry by prompting the user for
     * values
     *
     * @since 20141016
     * @author BJ MacLean
     */
    public JournalEntry() {
        

    }

    /**
     * This constructor will create a journal entry based on the line read from
     * the file.
     *
     * @param line (from the file)
     * @since 20141016
     * @author BJ MacLean
     *
     */
    public JournalEntry(String line) {
        StringTokenizer st = new StringTokenizer(line, "$");
        dateOfEntry = (String) st.nextElement();
        weight = (String) st.nextElement();
        entry = (String) st.nextElement();
    }

        /**
     * This constructor will create a journal entry based on the line read from
     * the file.
     *
     * @param line (from the file)
     * @since 20141016
     * @author BJ MacLean
     *
     */
    public JournalEntry(String dateOfEntry, String weight, String description) {
        this.dateOfEntry = dateOfEntry;
        this.weight = weight;
        entry = description;
    }

    
    /**
     * This will return the journal entry formatted for writing to the file.
     *
     * @return
     * @since 20141016
     * @author BJ MacLean
     */
    public String getLineForFile() {
        return dateOfEntry + "$" + weight + "$" + entry + "$";
    }

    /**
     * This will return the journal entry formatted for viewing by the user.
     *
     * @return
     * @since 20141016
     * @author BJ MacLean
     */
    public String toString() {
        return "Date:  " + dateOfEntry + System.lineSeparator()
                + "Weight:  " + weight + System.lineSeparator()
                + "Entry:  " + entry + System.lineSeparator()
                + System.lineSeparator();
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
    
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }
    
    

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    
    
}
