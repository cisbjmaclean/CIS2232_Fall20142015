/*
 * This class will hold the list of journal entries for the user.  It will provide
 * some functionality to allow the user to add/view entries.
 */
package fitnessjournal;

import static fitnessjournal.JournalEntry.file;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.nio.file.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.nio.file.StandardOpenOption.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author dmaclean31977 modified by BJ
 */
public class Journal {

    private ArrayList<JournalEntry> journal = new ArrayList();

    public void add(){
        journal.add(new JournalEntry());
    }
    public void writeToFile() {
        OutputStream output;
        BufferedWriter writer;
        try { // try to write contents of journal entries user typed to a file
            output = new BufferedOutputStream(Files.newOutputStream(JournalEntry.file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(output));
            // loop through each journal entry and write to a file
            for (int i = 0; i < journal.size(); i++) {
                writer.write(journal.get(i).getLineForFile());
                writer.newLine();
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            // dsplay message to user if cannot open file
            System.out.println("Error writing to file");
        }
    }

    /**
     * This method will display the entries in the journal.
     *
     * @since 20141016
     * @author BJ MacLean
     */
    public void viewEntries() {
        if (journal.size() == 0) { // display to user there are no entries
            System.out.println("There are no entries");
        } else { // loop through the array list to print out all journal entries

            for (JournalEntry entry : journal) {
                System.out.println(entry);
            }
        }
    }

    /**
     * This method will load the journal entries from the file.
     *
     * @since 20141016
     * @author BJ MacLean
     */
    public void loadEntries() {

        // if file exists and has data inside file, read the contents and store in a class variable
        if (Files.exists(file)) {
            try {
                // try to open file for read access
                InputStream input = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line = reader.readLine();
                // while each line is being read from the file push the contents to the ArrayList
                while (line != null) {
                    journal.add(new JournalEntry(line));
                    line = reader.readLine();
                }
            } catch (Exception e) {
                // Display error message to user if cdannot open file
                System.out.println("Error reading file");
            }
        }
    }

}
