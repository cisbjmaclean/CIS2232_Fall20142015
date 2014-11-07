/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwebservice;

import services.Validate;
import services.Validate_Service;

/**
 *
 * @author bjmaclean
 */
public class TestWebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validate_Service vs = new Validate_Service();
        Validate validate = vs.getValidatePort();
        //valid
        System.out.println(validate.validate("bjmaclean","bjmacleanpw"));
        //invalid
        System.out.println(validate.validate("bjmaclean","wrong"));
    }
    
}
