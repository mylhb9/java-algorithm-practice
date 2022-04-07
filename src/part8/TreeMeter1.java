package part8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMeter1 {
    Integer[][] edges;
    boolean[][] checks;
    int n;
    int destination;
    int count = 0;
    List<Integer> countList = new ArrayList<>();
    public void printMeter(int x) {
        for(int i=0; i<n; i++) {
            if(edges[x][i] == 1 && !checks[x][i] && i !=destination ) {
                checks[x][i] = true;
                checks[i][x] = true;
                count++;
                printMeter(i);
                count--;
            } else if(i==destination && edges[x][i] == 1 && !checks[x][i]){
                count++;
                countList.add(count);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");

        int n = Integer.parseInt(strArr[0]);
        int X = Integer.parseInt(strArr[1]);
        int Y = Integer.parseInt(strArr[2]);

        // 간선 정보 받을 공간 초기화
        Integer[][] edges = new Integer[n][n];
        // 간선 방문 여부 초기화
        boolean[][] checks = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                edges[i][j] = 0;
                checks[i][j] = false;
            }
        }

        // 간선 정보 입력 받기
        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            edges[Integer.parseInt(inputArr[i][0])][Integer.parseInt(inputArr[i][1])] = 1;
            edges[Integer.parseInt(inputArr[i][1])][Integer.parseInt(inputArr[i][0])] = 1;
        }






        TreeMeter1 m = new TreeMeter1();
        m.n = n;
        m.destination = Y;
        m.edges = edges;
        m.checks = checks;
        m.printMeter(X);
        System.out.println(m.countList.get(0));

    }
}

