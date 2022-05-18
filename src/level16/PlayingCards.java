package level16;

import java.util.Scanner;

public class PlayingCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[3];
        for(int i=0; i<N; i++) {
            int a = sc.nextInt();
            if(i==0) {
                arr[0] = 0;
                arr[1] = a;
                arr[2] = a;
            } else {
                int temp1 = arr[0];
                int temp2 = arr[1];
                arr[0] = Math.max(Math.max(arr[0], arr[1]), arr[2]);
                arr[1] = temp1 + a;
                arr[2] = temp2 + a;
            }
        }
        System.out.println(Math.max(Math.max(arr[0], arr[1]), arr[2]));
    }
}
