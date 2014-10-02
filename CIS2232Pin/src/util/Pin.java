/**
 * This class will contain code assiated with the Pin number required to check in
 * to the class attendance.
 */
package util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bjmaclean
 */
public class Pin {

    /**
     *
     * This method will provide the PIN for a given course. This will be a hash
     * value based on the date and the course code.
     *
     * @param courseCode
     * @return
     */
    public static int getTodaysPin(String courseCode) {

        int pin = 0;
        int totalOfAsci = 0;

        // get asci of cousre code
        for (int x = 0; x < courseCode.length(); x++) {
            totalOfAsci += (int) courseCode.charAt(x);
        }

        //  Get code from date
        Date date = null; // your date
        Calendar cal = Calendar.getInstance();
        // cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        // Add totals
        
        pin = totalOfAsci * (year + month + day );
        
        System.out.println(pin);

        // The daily pin will be generated based on the sum of the ascii codes of the 
        // course code multiplied by the sum of the digits in today's date (yyyymmdd format).
        // To limit the length of the pin, the result should never be more than six digits.  
        //generate the code for this based on the description above.
        return pin;

    }

    public static boolean validatePin(String courseName, String pin){
        
        return pin.equals(String.valueOf(getTodaysPin(courseName)));
    }
}
