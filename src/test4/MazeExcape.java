package test4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Axis {
    int x;
    int y;
}

public class MazeExcape {
    int[][] map;
    int N, M;
    boolean[][] check;
    Queue<Axis> queue = new LinkedList<>();
    int[] dx = {1, -1 ,0 ,0};
    int[] dy = {0, 0 ,1, -1};
    public void BFS(int x, int y, int[][] countArr) {
        Axis axis = new Axis();
        axis.x = x;
        axis.y = y;
        queue.offer(axis);
        check[x][y] = true;
        countArr[x][y] = 0;
        while(!queue.isEmpty()) {
            Axis current = queue.poll();
            int curX = current.x;
            int curY = current.y;

            for(int i=0; i<4; i++) {
                int xx = curX + dx[i];
                int yy = curY + dy[i];

                if(xx >=1 && xx <= N && yy >= 1 && yy <=M && !check[xx][yy]) {
                    check[xx][yy] = true;
                    countArr[xx][yy] = countArr[curX][curY] + 1;
                    if(map[xx][yy] == 0) {
                        Axis newAxis = new Axis();
                        newAxis.x = xx;
                        newAxis.y = yy;
                        queue.offer(newAxis);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N+2][M+2];

        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                if(i == 0 || i == N+1 || j == 0 || j == M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = sc.nextInt();
                }
            }
        }
        MazeExcape m = new MazeExcape();
        m.N = N;
        m.M = M;
        m.check = new boolean[1001][1001];
        m.map = map;

        int[][] countArr1 = new int[1001][1001];
        m.BFS(N, 1, countArr1);

        m.check = new boolean[1001][1001];

        int[][] countArr2 = new int[1001][1001];
        m.BFS(1, M, countArr2);


        int[][] countArr = new int[1001][1001];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                countArr[i][j] = countArr1[i][j] + countArr2[i][j];
            }
        }

        int min = 10000000;
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(countArr1[i][j] != 0 && countArr2[i][j] != 0) {
                    min = Math.min(min, countArr[i][j]);
                }
            }
        }
        System.out.println(min);
    }
}
