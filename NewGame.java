package rolenzo.java2.ex1;

import java.security.Principal;
import java.util.*;
public class NewGame {
    private char[] ansArr = new char[4];
    public NewGame() {
        int[] numCheckArr = new int[10];
        int temp;
        
<<<<<<< .merge_file_9aCD5I
        // generate 4 random number
=======
        // generate 4 random number
>>>>>>> .merge_file_em0Q8S
        for (int i = 0; i < 4;) {
            if (i == 0) {
                temp =(int)(Math.random() * 9) + 1;
                numCheckArr[temp] = 1;
                ansArr[i] = (char)('0' + temp);
                ++i;
            }
            else {
                temp =(int)(Math.random() * 9);
                if(numCheckArr[temp] != 1) {
                    numCheckArr[temp] = 1;
                    ansArr[i] = (char)('0' + temp);
                    ++i;
                }
            }
        }
    }

    public char[] getAns() {
        return ansArr;
    }
    
}
