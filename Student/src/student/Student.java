/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author bjmaclean
 */
public class Student implements Serializable{
    public static final String FILE_NAME = "c:\\cis2232\\student.txt";
    public static final String FILE_NAME_SER = "c:\\cis2232\\object.ser";
    public static Scanner input = new Scanner(System.in);
    
    //Student attributes
    private String studentId;
    private String lastName, firstName, dob;
    
    public static int RECORD_LENGTH=38;
    /*
        The record layout is made up of the student id (3), the first name (15), 
        the last name (15) and the dob (8).
    */
    
    
    public static String RECORD_LAYOUT= "000,               ,               ,        "+System.getProperty("line.separator");
    public static int NAME_LENGTH=15;
    public static int DOB_LENGTH=8;
    public static int STUDENT_ID_LENGTH=3;
    public static final int NUMBER_OF_RECORDS = 100;
    
    /**
     * This method should format the student information in a string matching the record 
     * layout.
     * 
     * @return 
     */
    
    public String toStringFormatted(){
        //Have to pad the strings to make sure 
        return this.studentId;  
    }
    
    public Student(){
        System.out.println("Please enter the student ID");
        studentId= input.nextLine();
        System.out.println("Please enter the student last name");
        lastName = input.nextLine();
        System.out.println("Please enter the student first name");
        firstName = input.nextLine();
        System.out.println("Please enter the student date of birth (yyyymmdd");
        dob = input.nextLine();
    }
    
    /**
     * This constructor will create the instance based on the string loaded from
     * the file.  This takes some work and debug statements make figuring out how to 
     * substring the string correctly.
     * 
     * @param loadString 
     * @since 20140918
     * @author BJ
     */
    public Student(String loadString){
        this.studentId = loadString.substring(0, Student.STUDENT_ID_LENGTH).trim();
        //if (this.studentId.trim().equals("68")) System.out.println("string=***"+loadString+"***");
        
        
        
        //Get the first name part
        int soFar = Student.STUDENT_ID_LENGTH+1;
        int soFarNext = soFar + Student.NAME_LENGTH;
        this.firstName = loadString.substring(soFar,soFarNext).trim();
        //if (this.studentId.equals("68")) System.out.println("first name=***"+this.firstName+"***");
        
        //Get the last name part 
        soFar = soFarNext+1;
        soFarNext += Student.NAME_LENGTH+1;
        this.lastName = loadString.substring(soFar,soFarNext).trim();
        //if (this.studentId.equals("68")) System.out.println("last name=***"+this.lastName+"***");

        //Get the last piece of the string
        soFar = soFarNext+1;
        this.dob = loadString.substring(soFar).trim();
        //if (this.studentId.equals("68")) System.out.println("dob=***"+this.dob+"***");

    }
    
    public String toString(){
        return     "Student ID:   \t"+studentId
                +"\nFrist Name:   \t"+firstName
                +"\nLast Name:    \t"+lastName
                +"\nDate of Birth:\t"+dob;
    }
    public String fileOutputString(){

        String studentIdPart = String.format("%"+STUDENT_ID_LENGTH+"s", String.valueOf(studentId));
        String studentFirstNamePart = String.format("%"+NAME_LENGTH+"s", String.valueOf(firstName));
        String studentLastNamePart = String.format("%"+NAME_LENGTH+"s", String.valueOf(lastName));
        String studentDOBPart = String.format("%"+DOB_LENGTH+"s", String.valueOf(dob));
        
        return studentIdPart+","+studentFirstNamePart+","+studentLastNamePart+","+studentDOBPart+System.getProperty("line.separator");
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
