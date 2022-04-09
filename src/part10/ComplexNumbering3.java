package part10;

import java.util.*;

public class ComplexNumbering3 {
    Integer[][] map;
    Integer[] mx = {1, -1, 0, 0};
    Integer[] my = {0, 0, 1, -1};

    int DFS(int x, int y) {
        int count = 0;

        map[x][y] = 0;
        count++;
        for(int i=0; i<4; i++) {
            if(map[x+mx[i]][y+my[i]] == 1) {
                count += DFS(x+mx[i], y+my[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] inputArr = new String[N][N];
        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split("");
        }

        Integer[][] map = new Integer[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<N+2; j++) {
                if(i == 0 || i == N+1 || j == 0 || j == N+1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(inputArr[i-1][j-1]);
                }
            }
        }
        ComplexNumbering3 m = new ComplexNumbering3();
        m.map = map;
        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(map[i][j] == 1) {
                    countList.add(m.DFS(i, j));
                }
            }
        }
        Collections.sort(countList);
        System.out.println(countList.size());
        for(int i=0; i<countList.size(); i++) {
            System.out.println(countList.get(i));
        }

    }
}
