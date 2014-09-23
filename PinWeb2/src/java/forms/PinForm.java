/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author bjmaclean
 */
public class PinForm extends ValidatorForm {
    private String name, courseName, pin;

    public PinForm() {
        System.out.println("Calling default constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    
    
}
