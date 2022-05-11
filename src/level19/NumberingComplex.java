package level19;

import java.util.*;

public class NumberingComplex {
    int[][] map;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int getSum(int x, int y) {
        int count = 0;
        map[x][y] = 0;
        count++;
        for(int i=0; i<4; i++) {
            if(map[x+dx[i]][y+dy[i]] == 1) {
                count += getSum(x+dx[i], y+dy[i]);
            }
        }
        return count;
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
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(strMap[i-1][j-1]);
            }
        }

        NumberingComplex m = new NumberingComplex();
        m.map = map;

        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(m.map[i][j] == 1) {
                    countList.add(m.getSum(i, j));
                }
            }
        }
        Collections.sort(countList);
        int length = countList.size();
        System.out.println(length);
        for(int i=0; i<length; i++) {
            System.out.println(countList.get(i));
        }
        sc.close();
    }
}
