package level5;

import java.util.Arrays;
import java.util.Scanner;

public class FindkthNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);

        String[] inputArr = sc.nextLine().split(" ");
        Integer[] sortArr = new Integer[N];
        for(int i=0; i<N; i++) {
            sortArr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(sortArr);
        System.out.println(sortArr[N-k]);
    }
}
