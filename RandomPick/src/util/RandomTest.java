/*
 * BJ MacLean (CIS1201)
 */

package util;

/**
 *
 * @author bjmaclean
 */
public class RandomTest {

    public static void main(String[] args){
        System.out.println("testing random");
        RandomPick theRandom = new RandomPick("CIS2232",9);
        int[] picks = new int[9];
        for (int i = 0; i<10000; ++i){
            int randomPick = theRandom.getRandomPick();
            //System.out.println("random pick in test ="+randomPick);
            picks[randomPick-1]++;
        }
        for (int i = 0; i<9; ++i){
            System.out.println("Picked "+(i+1)+" this many times:"+picks[i]);
        }
        
    }
    
}
