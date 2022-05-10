package level18;

import java.util.*;

public class ComplexNumbering {
    int[][] map;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int count = 0;
    public void DFS(int x, int y) {
        map[x][y] = 0;
        count++;
        for(int i=0; i<4; i++) {
            if(map[x+dx[i]][y+dy[i]] == 1) {
                DFS(x+dx[i], y+dy[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[][] strMap = new String[N][N];
        for(int i=0; i<N; i++) {
            strMap[i] = sc.nextLine().split("");
        }
        int[][] map = new int[N+2][N+2];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                map[i][j] = Integer.parseInt(strMap[i-1][j-1]);
            }
        }
        ComplexNumbering m = new ComplexNumbering();
        m.map = map;
        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(m.map[i][j] == 1) {
                    m.DFS(i, j);
                    countList.add(m.count);
                    m.count = 0;
                }
            }
        }
        Collections.sort(countList);
        int size = countList.size();
        System.out.println(size);
        for(int i=0; i<size; i++) {
            System.out.println(countList.get(i));
        }
        sc.close();
    }
}
