package level2;

import java.util.Scanner;

public class Cardgame {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strA = sc.nextLine().split(" ");
        Integer[] intA = new Integer[10];
        String[] strB = sc.nextLine().split(" ");
        Integer[] intB = new Integer[10];

        for(int i=0; i<10; i++) {
            intA[i] = Integer.parseInt(strA[i]);
            intB[i] = Integer.parseInt(strB[i]);
        }

        int countA = 0;
        int countB = 0;

        for(int i=0; i<10; i++) {
            if(intA[i] > intB[i]) {
                countA++;
            } else if(intA[i] < intB[i]) {
                countB++;
            }
        }
        if(countA > countB) {
            System.out.println("A");
        } else if(countA < countB) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }



    }
}
