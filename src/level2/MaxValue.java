package level2;

import java.util.*;

public class MaxValue {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[9];
        Integer[] intArr = new Integer[9];
        for(int i=0; i<9; i++) {
            strArr[i] = sc.nextLine();
        }
        for(int i=0; i<9; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        int max = 0;
        int index = 0;
        for(int i=0; i<9; i++) {
            if(intArr[i] > max) {
                max = intArr[i];
                index = i+1;
            }
        }

        System.out.println(max);
        System.out.println(index);

    }
}
