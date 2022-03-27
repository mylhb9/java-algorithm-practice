package part8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n;
    String[] visitedArr;
    String[][] nodeArr;

    public void frontVisitTree(int idx, int row) {
        if(idx == n) {
            System.out.println(Arrays.toString(visitedArr));
        } else if(idx < n) {
            for(int j=1; j<3; j++) {

                    if(!nodeArr[row][j].equals("-1")) {
                        visitedArr[idx] = nodeArr[row][j - 1];
                        row = Integer.parseInt(nodeArr[row][j]);
                        if(row != -1) {
                            frontVisitTree(idx+1, row);
                        }
                    } else {
                        visitedArr[idx] = nodeArr[row][j];
                        row = Integer.parseInt(nodeArr[row][j]);
                        if(row != -1) {
                            frontVisitTree(idx+1, row);
                        }
                    }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[][] strArr = new String[n][3];

        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        Main m = new Main();
        m.n = n;
        m.nodeArr = strArr;
        m.visitedArr = new String[100000];
        Arrays.fill(m.visitedArr, "*");
        m.frontVisitTree(1, 0);



    }
}
