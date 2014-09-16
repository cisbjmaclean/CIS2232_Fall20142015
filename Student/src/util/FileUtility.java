package util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.Student;

/**
 *
 * @author bjmaclean
 */
public class FileUtility {

    public static void fileWrite(BufferedWriter writer, String toWrite) throws IOException {
        writer.write(toWrite);
        writer.newLine();
        writer.flush();
    }

    public static void initializeFile(String fileName){
        //could use this to initialize 100 records in the file.
        Path file = Paths.get(fileName);
        byte[] data = Student.RECORD_LAYOUT.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            for (int i = 0; i < Student.NUMBER_OF_RECORDS; ++i){
                writer.write(Student.RECORD_LAYOUT, 0, Student.RECORD_LAYOUT.length());
            }
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
}
