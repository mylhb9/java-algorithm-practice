package level16;

import java.util.Scanner;

public class PushButton {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] R = new int[N+1];
        int[] G = new int[N+1];
        int[] B = new int[N+1];

        for(int i=0; i<N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();


            R[i+1] = Math.max(a+G[i], a+B[i]);
            G[i+1] = Math.max(b+R[i], b+B[i]);
            B[i+1] = Math.max(c+R[i], c+G[i]);
        }
        System.out.println(Math.max(Math.max(R[N], G[N]), B[N]));
    }
}
