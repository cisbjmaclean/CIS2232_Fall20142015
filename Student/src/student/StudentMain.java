/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FileUtility;

/**
 *
 * @author bjmaclean
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    private static Path path = Paths.get("c:\\cis2232\\student.txt");

    public static void main(String[] args) {
        
        FileUtility.initializeFile("c:\\cis2232\\student.txt");
        HashMap<String, Student> students = new HashMap();
        String option;
        Scanner input = new Scanner(System.in);

        String menu = "Please select from option below"
                + "\nA)Add a student"
                + "\nB)View all students"
                + "\nC)Edit a student"
                + "\nX)Exit";

        System.out.println(menu);
        option = input.nextLine().toUpperCase();
        OutputStream output;
        BufferedWriter writer = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(path, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(output));

            while (!option.equalsIgnoreCase("x")) {
                switch (option) {
                    case "A":
                        Student student = new Student();
                        students.put(student.getStudentId(), student);
                        //FileUtility.fileWrite(writer, student.fileOutputString());
                        
                        break;
                    case "B":
                        for (String variableName : students.keySet()) {
                            System.out.println(students.get(variableName) + "\n");
                        }
                        break;
                    case "C":
                        System.out.println("Future functionality");
                        break;
                    default:
                        System.err.println("Invalid option");
                }

                System.out.println(menu);
                option = input.nextLine().toUpperCase();

            }
        } catch (IOException ex) {
            System.err.println("There was an IO error");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println("IO exception caught.(closing)");
            }
        }

    }



}
