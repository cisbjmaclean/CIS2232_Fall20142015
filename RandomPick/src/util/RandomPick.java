/*
 * BJ MacLean (CIS1201)
 */

package util;

/**
 *
 * @author bjmaclean
 */
public class RandomPick {
    
    private String courseName;
    private int maxNumber;

    public RandomPick(){
        //do nothing
    }
    
    public RandomPick(String courseName, int maxNumber) {
        this.courseName = courseName;
        this.maxNumber = maxNumber;
    }
    
    public int getRandomPick(){
        
        double temp = Math.random();
       // System.out.println("Math.random gave ***"+temp+"***");
        int tempRandom = (int) (temp * maxNumber+1);
        //System.out.println("The random number for "+courseName+" is "+tempRandom);
        return tempRandom;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    
    
}
