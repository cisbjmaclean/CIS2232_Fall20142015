/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import database.AccessDAO;
import forms.Login;

/**
 *
 * @author bjmaclean
 */
public class AccessBO {
    
        public static boolean validate(Login login) throws Exception {
            return AccessDAO.validate(login);
        }
    
}
