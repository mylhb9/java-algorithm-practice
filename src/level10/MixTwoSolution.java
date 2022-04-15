package level10;

import java.util.*;

public class MixTwoSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[] strArr = sc.nextLine().split(" ");
        Integer[] inputArr = new Integer[N];
        for(int i=0; i<N; i++) {
            inputArr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(inputArr);
        for(int i=0; i<inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }


    }
}