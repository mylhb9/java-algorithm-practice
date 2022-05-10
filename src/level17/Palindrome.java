package level17;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] data = sc.nextLine().toCharArray();
        int length = data.length;
        int[][] arr = new int[length][length];
        for(int i=0; i<length; i++) {
            arr[i][i] = 0;
        }
        for(int i=length-2; i>=0; i--) {
            for (int j = i+1; j <length; j++) {
                if (data[i] == data[j]) {
                    arr[i][j] = arr[i + 1][j - 1];
                } else {
                    arr[i][j] = Math.min(arr[i + 1][j], arr[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(arr[0][length-1]);
    }
}
