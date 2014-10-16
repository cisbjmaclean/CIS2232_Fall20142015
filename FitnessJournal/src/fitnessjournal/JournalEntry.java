/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnessjournal;

import java.nio.file.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author dmaclean31977
 */
public class JournalEntry {

    //Attributes of a journal entry
    private String entry;
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
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date:");
        dateOfEntry = input.nextLine();
        System.out.print("Enter weight:");
        weight = input.nextLine();
        System.out.print("Enter description of day:");
        entry = input.nextLine();

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

}
