package actions;

import forms.PinForm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.Pin;

/**
 *
 * @author bjmaclean
 */
public class EnterPin extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        ActionForward findForward = mapping.findForward("welcome");

        PinForm formPin = (PinForm) request.getAttribute("pinForm");

        System.out.println("Name="+formPin.getName());
        System.out.println("courseName="+formPin.getCourseName());
        System.out.println("Name="+formPin.getPin());
        
        System.out.println("This is where the functionality to verify the pin will be.");
        int todaysPin = Pin.getTodaysPin(formPin.getCourseName());
                

        if (todaysPin == Integer.parseInt(formPin.getPin())) {
            System.out.println("Pin is Correct");

            File file = new File("c:\\CIS2232\\add.txt");
            try {
                file.createNewFile();
                BufferedWriter writer;
                writer = new BufferedWriter(new FileWriter(file,true));
                writer.write(formPin.getName());
                writer.newLine();   
                writer.write(formPin.getCourseName());
                writer.newLine();                
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                System.err.println("Error happened.");
            }
            findForward = mapping.findForward("success");

        } else {
            System.out.println("Pin is  inCorrect");
            findForward = mapping.findForward("fail");
        }

        
        
        
        
        
        return findForward;

    }

}
