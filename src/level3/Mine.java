package level3;

import java.util.Scanner;

public class Mine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] mapSize = sc.nextLine().split(" ");
        int N = Integer.parseInt(mapSize[0]);
        int M = Integer.parseInt(mapSize[1]);

        String[] clickPosition = sc.nextLine().split(" ");
        int x = Integer.parseInt(clickPosition[0]);
        int y = Integer.parseInt(clickPosition[1]);

        String[][] strMap = new String[N][M];
        Integer[][] map = new Integer[N+2][M+2];

        for(int i=0; i<N; i++) {
            strMap[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i+1][j+1] = Integer.parseInt(strMap[i][j]);
            }
        }
        if(map[x][y] == 0) {
            int sum = map[x-1][y-1] + map[x-1][y] + map[x-1][y+1] + map[x][y-1] + map[x][y+1] + map[x+1][y-1] + map[x+1][y] + map[x+1][y+1];
            System.out.println(sum);
        } else {
            System.out.println("game over");
        }
    }
}
