package level5;

import java.util.Scanner;

public class PROSJEK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] inputArr = sc.nextLine().split(" ");
        Integer[] intArr = new Integer[N];
        for(int i=0; i<inputArr.length; i++) {
            intArr[i] = Integer.parseInt(inputArr[i]);
        }

        Integer[] answerArr = new Integer[N];
        int sum = 0;
        for(int i=0; i<N; i++) {
            answerArr[i] = intArr[i]*(i+1)-sum;
            sum+=answerArr[i];
        }
        for(int i=0; i<N; i++) {
            System.out.print(answerArr[i] + " ");
        }
    }
}
