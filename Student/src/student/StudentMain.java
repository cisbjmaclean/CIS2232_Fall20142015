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
    private static Path path = Paths.get(Student.FILE_NAME);

    public static void main(String[] args) {

        
        //If the file does not exist, create it.
        if (!Files.exists(path)) {
            FileUtility.initializeFile(Student.FILE_NAME);
        }


        //create the hashmap of students and load it.
        
        HashMap<String, Student> students = FileUtility.loadFromRandomAccessFile(Student.FILE_NAME);
       
        
        
        String option;
        Scanner input = new Scanner(System.in);

        String menu = "Please select from option below"
                + "\nA)Add a student"
                + "\nB)View all students"
                + "\nC)View a student"
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
                        FileUtility.addRecord(student.fileOutputString(),Student.FILE_NAME);

                        //FileUtility.fileWrite(writer, student.fileOutputString());
                        //FileUtility.fileWriteRandom(student);
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
            
            //At the end replace the file with the modified hashmap.
            
            FileUtility.saveStudents(students, Student.FILE_NAME);
            
            
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
