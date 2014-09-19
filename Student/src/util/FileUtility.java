package util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Instrument;
import student.Student;
import static student.Student.RECORD_LAYOUT;

/**
 *
 * @author bjmaclean
 */
public class FileUtility {

    /**
     * This method will write to a file.
     *
     * @since 20140918
     * @author BJ
     * @param writer
     * @param toWrite
     * @throws IOException
     */
    public static void fileWrite(BufferedWriter writer, String toWrite) throws IOException {
        writer.write(toWrite);
        writer.newLine();
        writer.flush();
    }

 

    
    /**
     * This method will initialize the file to a starting point with no student
     * information in it. It will have student ids from 0-99.
     *
     * @since 20140918
     * @author BJ
     * @param fileName
     */
    public static void initializeFile(String fileName) {

        

//        //could use this to initialize 100 records in the file.
//        Path file = Paths.get(fileName);
//        byte[] data = Student.RECORD_LAYOUT.getBytes();
//        ByteBuffer buffer = ByteBuffer.wrap(data);
//
//        try {
//            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
//
//            String tempStudentId = "";
//            for (int i = 0; i < Student.NUMBER_OF_RECORDS; ++i) {
//                tempStudentId = String.format("%" + Student.STUDENT_ID_LENGTH + "s", String.valueOf(i));
//                String tempReplaced = Student.RECORD_LAYOUT.substring(Student.STUDENT_ID_LENGTH);
//                writer.write(tempStudentId + tempReplaced, 0, Student.RECORD_LAYOUT.length());
//            }
//            writer.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

        /**
     * 
     * @param s
     * @param fileName 
     */
    
    public static void addRecord(String s, String fileName) {
        //this method takes the output string from a new student and writes it
        //on the corresponding line of the txt file
        Path file = Paths.get(fileName);
        byte[] data = s.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        try {
            FileChannel fc = null;
            int id = Integer.parseInt(s.substring(0, 3).trim());
            System.out.println(id);
            fc = (FileChannel) Files.newByteChannel(file, WRITE);
            fc.position((id-1) * RECORD_LAYOUT.length());
            fc.write(buffer);
            fc.close();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error message: " + e);
        }
    }

    
    /**
     * This method will write an object to a file.  
     * 
     * @param objectToWrite 
     */
    public static void writeObjectToFile(HashMap outputToWrite){
        String pathLocation = "c:\\cis2232\\object.ser";
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath(pathLocation);
 
        try {
         FileOutputStream fileOut =
         new FileOutputStream(pathLocation);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(outputToWrite);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in "+pathLocation);        } catch (NoSuchFileException ex) {
 
        } catch (IOException ex1) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex1);
        }
 
    }
    
    /**
     * This method will load a load students into a HashMap
     *
     * @param fileName
     * @return HashMap containing students
     * @since 20140918
     * @author BJ
     */
    public static HashMap loadFromRandomAccessFile(String fileName) {
        HashMap<String, Student> students = new HashMap();

        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
            String lineRead = in.readLine();

            //While not at the end of the file, create new students based on the line read.  This
            //is done by using the constructor which creates a Student based on the record layout.  
            //Add the students to the HashMap.
            while (lineRead != null) {
                //remember to create a new Student IN the loop!
                Student newStudent = new Student(lineRead);
                students.put(newStudent.getStudentId(), newStudent);

                //Read the next line.
                lineRead = in.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    /**
     * This method will take the hashmap and write the students to the file.
     *
     * @since 20140918
     * @author BJ
     * @param students
     * @param fileName
     */
    public static void saveStudents(HashMap<String, Student> students, String fileName) {

        //could use this to initialize 100 records in the file.
        Path file = Paths.get(fileName);

        try {
            //Do we need to do this??
            //Files.deleteIfExists(file);

            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            String tempStudentId = "";
            //Loop through the students in the HashMap

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

