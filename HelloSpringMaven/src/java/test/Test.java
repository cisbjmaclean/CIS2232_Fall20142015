/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author bjmaclean
 */
public class Test {
    
    ArrayList<String> test;
    public Test(){
        test = new ArrayList();
        test.add("A");
        test.add("B");
        test.add("C");
    }
    
    public ArrayList<String> getTestArraylist(){
        return test;
    }
    
}
