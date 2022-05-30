package additiontype;

import java.util.Scanner;

public class PlantTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 2 3 4 5 6 7 8 9 10
        //     3 4   6 7   9 10

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        boolean[] tree = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = true;
        }

        for(int i=1; i<=M; i++) {
            int a = sc.nextInt();
            tree[a] = false;
        }


        int end = 0;
        int count = 0;
        for(int i=0; i<K; i++) {
            while(end <= N) {

            }
        }

    }
}
