/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cis2232_example_fall2014;

import java.io.BufferedWriter;
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
        int todaysPin = Pin.getTodaysPin("CIS2232");
        
        System.out.println("Todays pin is "+todaysPin);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter your userid");        
        String userId = input.nextLine();
        
        System.out.println("Enter the pin");        
        String inPin = input.nextLine();
        


        
        if (Integer.parseInt(inPin) == todaysPin) {
            try {
                //success
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\cis2232\\attendance.txt", true));                
                
                bufferedWriter.write(userId);
                bufferedWriter.flush();
                bufferedWriter.close();
                //osw = new OutputStreamWriter();
            } catch (IOException ex) {
                Logger.getLogger(CIS2232_Example_Fall2014.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    
        
    }
    }}
