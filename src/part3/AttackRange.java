package part3;

import java.util.Scanner;

public class AttackRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        int r = Integer.parseInt(strArr[2]);



        String[][] map = new String[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==x-1 && j==y-1) {
                    map[i][j] = "x";
                } else {
                    map[i][j] = "0";
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=1; k<=r; k++) {
                    if(Math.abs(i-(x-1)) + Math.abs(j-(y-1)) == k) {
                        map[i][j] = String.valueOf(k);
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
