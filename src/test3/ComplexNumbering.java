package test3;

import java.util.*;

// 문제: 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
public class ComplexNumbering {
    Integer[][] map;
    Integer[] mx = {1, -1, 0, 0};
    Integer[] my = {0, 0, 1, -1};
    public int DFS(int x, int y) {
        int count = 0;
        map[x][y] = 0;
        count++;

        for(int i=0; i<4; i++) {
            if(map[x+mx[i]][y+my[i]] == 1) {
                count+=DFS(x+mx[i], y+my[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
// 입력: 지도의 크기 N, N 줄에는 각각 N개의 자료가 입력됨
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        Integer[][] map = new Integer[N+2][N+2];
        String[][] inputArr = new String[N][N];

        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split("");
        }


        for(int i=0; i<N+2; i++) {
            for(int j=0; j<N+2; j++) {
                if(i == 0 || i == N+1 || j == 0 || j == N+1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(inputArr[i-1][j-1]);
                }
            }
        }
        ComplexNumbering m = new ComplexNumbering();
        m.map = map;
        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(m.map[i][j] == 1) {
                    countList.add(m.DFS(i, j));
                }
            }
        }
        Collections.sort(countList);
// 출력: 총 단지수를 출력하고, 각 단지내 집의수를 오름차순으로 정렬하여 한줄에 하나씩 출력
        System.out.println(countList.size());
        for(int i=0; i<countList.size(); i++) {
            System.out.println(countList.get(i));
        }
    }
}
