/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.util.Scanner;

/**
 *
 * @author bjmaclean
 */
public class Student {
    Scanner input = new Scanner(System.in);
    private String studentId;
    private String lastName, firstName, dob;
    
    public static int RECORD_LENGTH=38;
    /*
        The record layout is made up of the student id (3), the first name (15), 
        the last name (15) and the dob (8).
    */
    public static String RECORD_LAYOUT= "000,               ,               ,        ";
    public static final int NUMBER_OF_RECORDS = 100;
    
    public Student(){
        System.out.println("Please enter the student ID");
        studentId= input.nextLine();
        System.out.println("Please enter the student last name");
        lastName = input.nextLine();
        System.out.println("Please enter the student first name");
        firstName = input.nextLine();
        System.out.println("Please enter the student date of birth name");
        dob = input.nextLine();
    }
    
    public String toString(){
        return     "Student ID:   \t"+studentId
                +"\nFrist Name:   \t"+firstName
                +"\nLast Name:    \t"+lastName
                +"\nDate of Birth:\t"+dob;
    }
    public String fileOutputString(){
        return studentId+","+firstName+","+lastName+","+dob;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
}
