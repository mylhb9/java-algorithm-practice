package level2;

import java.util.Scanner;

public class FindSecondMinimum {
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

        for(int i=0; i<9; i++) {
            for(int j=0; j<8; j++) {
                if(intArr[j] > intArr[j+1]) {
                    int pivot = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = pivot;
                }
            }
        }
        int index = 0;
        for(int i=0; i<9; i++) {
            if(strArr[i].equals(String.valueOf(intArr[1]))) {
                index = i+1;
            }
        }
        System.out.println(intArr[1]);
        System.out.println(index);
    }
}
