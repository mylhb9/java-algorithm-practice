package part8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TreeHeight1 {
    List<Integer> countList = new ArrayList<>();
    int count = 0;
    int n = 0;
    Integer[][] edges;
    boolean[][] checks;


    void findHeight(int root) {
        for(int i=0; i<n; i++) {
            if(edges[root][i] == 1 && !checks[root][i]) {
                count++;
                checks[root][i] = true;
                checks[i][root] = true;
                findHeight(i);
                count--;
            } else {
                countList.add(count);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        // 간선 정보 담기위한 공간 초기화
        Integer[][] edges = new Integer[n][n];
        boolean[][] checks = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                edges[i][j] = 0;
                checks[i][j] = false;
            }
        }

        // 입력받은 정보를 토대로 간선 정보를 저장
        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            edges[Integer.parseInt(inputArr[i][1])][Integer.parseInt(inputArr[i][0])] = 1;
            edges[Integer.parseInt(inputArr[i][0])][Integer.parseInt(inputArr[i][1])] = 1;
        }


        TreeHeight1 m = new TreeHeight1();
        m.edges = edges;
        m.checks = checks;
        m.n = n;
        m.findHeight(r);

        int max = 0;
        for(int i=0; i<m.countList.size(); i++) {
            max = Math.max(max, m.countList.get(i));
        }
        System.out.println(max);


    }
}
