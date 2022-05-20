package test6;

import java.util.*;

class Point {
    int x;
    int y;
}
public class Escape {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visisted;
    int[][] map;
    int N, M;

    public void BFS(int x, int y, int[][] answer) {
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point();
        point.x = x;
        point.y = y;
        queue.offer(point);
        visisted[x][y] = true;
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i=0; i<4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];
                if(!visisted[xx][yy] && xx>=1 && yy>=1 && xx<=N && yy<=M) {
                    answer[xx][yy] = answer[current.x][current.y] + 1;
                    visisted[xx][yy] = true;
                    if(map[xx][yy] == 0) {
                        Point newPoint = new Point();
                        newPoint.x = xx;
                        newPoint.y = yy;
                        queue.offer(newPoint);
                    }

                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        // 0 이동 가능, 1 이동 불능

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
        Escape m = new Escape();
        m.map = map;
        m.N = N;
        m.M= M;

        m.visisted = new boolean[1005][1005];
        int[][] answer1 = new int[N+2][M+2];
        m.BFS(N, 1, answer1);

        m.visisted = new boolean[1005][1005];
        int[][] answer2 = new int[N+2][M+2];
        m.BFS(1,M, answer2);

        int min = 987987987;

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(answer1[i][j] != 0 && answer2[i][j] != 0) {
                    min = Math.min(min, answer1[i][j]+answer2[i][j]);
                }
            }
        }

        System.out.println(min);

        sc.close();
    }
}
