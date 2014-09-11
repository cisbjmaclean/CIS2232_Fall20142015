/**
 * This class will contain code assiated with the Pin number required to checkin 
 * to the class attendance.  
 */

package util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author bjmaclean
 */
public class Pin {
    
    /**
     * 
     * This method will provide the PIN for a given course.  This will be a hash 
     * value based on the date and the course code.
     * 
     * @param courseCode
     * @return 
     */
    
    public static int getTodaysPin(String courseCode){
        
        int pin = 0;
        
        // The daily pin will be generated based on the sum of the ascii codes of the 
        // course code multiplied by the sum of the digits in today's date (yyyymmdd format).
        // To limit the length of the pin, the result should never be more than six digits.  
        
        //generate the code for this based on the description above.
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd");
        String[] stringArray = dateFormat.format(date).split(",");
        int dateTotal = 0;
        for(String str : stringArray){
            dateTotal += Integer.parseInt(str);
        }
        char[] charArray = courseCode.toCharArray();
        int courseTotal = 0;
        for(char str : charArray){
            int num = (int) str;
            courseTotal += num;
        }
        
        pin = dateTotal * courseTotal;
        return pin;
        
    }
    
    
    
}
