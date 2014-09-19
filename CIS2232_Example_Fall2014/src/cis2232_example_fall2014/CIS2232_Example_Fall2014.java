/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis2232_example_fall2014;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Pin;

/**
 *
 * @author bjmaclean
 */
public class CIS2232_Example_Fall2014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your Name");
        String userName = input.nextLine();
        System.out.println("Please Enter your Course ID");
        String courseID = input.nextLine();
        int todaysPin = Pin.getTodaysPin(courseID);
        System.out.println("Please Enter your Todays Pin");
        int inputTodaysPin = input.nextInt();

        if (todaysPin == inputTodaysPin) {
            System.out.println("Pin is Correct");

            File file = new File("c:\\CIS2232\\add.txt");
            try {
                file.createNewFile();
                BufferedWriter writer;
                writer = new BufferedWriter(new FileWriter(file,true));
                writer.write(userName);
                writer.newLine();   
                writer.write(courseID);
                writer.newLine();                
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CIS2232_Example_Fall2014.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Pin is  in  Correct");
        }
    }
}
