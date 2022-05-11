package level19;

import java.util.*;

class Point {
    int x;
    int y;
}
public class FindMaze {
    int[][] map;
    int[][] answer;
    boolean[][] visited = new boolean[1003][1003];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        Point point = new Point();
        point.x = x;
        point.y = y;
        queue.offer(point);
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i=0; i<4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];
                if(!visited[xx][yy] && map[xx][yy] == 0) {
                    visited[xx][yy] = true;
                    answer[xx][yy] = answer[current.x][current.y] + 1;
                    Point newPoint = new Point();
                    newPoint.x = xx;
                    newPoint.y = yy;
                    queue.offer(newPoint);
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
                if(i == 0 || i == N+1 || j == 0 || j== M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = sc.nextInt();
                }

            }
        }
        FindMaze m = new FindMaze();
        m.map = map;
        m.answer = new int[1003][1003];
        m.BFS(N, 1);
        System.out.println(m.answer[1][M]);
        sc.close();
    }
}
