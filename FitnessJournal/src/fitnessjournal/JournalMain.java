/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnessjournal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bjmaclean
 */
public class JournalMain {
    
        public static void main(String[] args) {

        // create new Journal object
        Journal journal = new Journal();
        // load existing entries from the file.
        journal.loadEntries();
        
        // menu to display to user
        String menu = "Fitness Journal\n"
                + "A) Add a journal entry\n"
                + "V) View all journal entries\n"
                + "X) Exit";
        String choice = "";
        Scanner input = new Scanner(System.in);

        System.out.println(menu);
        choice = input.nextLine().toLowerCase();

        // provide user menu until they enter x
        while (!choice.equalsIgnoreCase("x")) {
            switch (choice.toLowerCase()) {
                case "a":
                    journal.add();
                    break;
                case "v":
                    journal.viewEntries();
                    break;
                case "x":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println(menu);
            choice = input.nextLine().toLowerCase();
        }
        journal.writeToFile();
    }

    
}
