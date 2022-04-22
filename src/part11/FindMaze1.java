package part11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 문제: N X M 의 지도가 주어진다.
// (N-1, 0) 에서 출발하여 (0, M-1) 까지 도착하는 최단거리를 출력하는 프로그램을 작성

// 입력: 첫째 줄에 지도의 세로길이 N과 지도의 가로길이 M이 주어진다
// 0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분을 나타낸다.
class Axis2 {
    int x;
    int y;
}
public class FindMaze1 {
    Queue<Axis2> queue = new LinkedList<>();
    boolean[][] check;
    int[][] countArr;
    int[][] map;
    int[] dx = {1, -1, 0 ,0};
    int[] dy = {0, 0, 1, -1};
    public void BFS(int x, int y) {
        Axis2 axis = new Axis2();
        axis.x = x;
        axis.y = y;

        queue.offer(axis);
        check[x][y] = true;
        countArr[x][y] = 0;

        while(!queue.isEmpty()) {
            Axis2 current = queue.poll();
            int curX = current.x;
            int curY = current.y;

            for(int i=0; i<4; i++) {
                int xx = curX + dx[i];
                int yy = curY + dy[i];

                if(map[xx][yy] == 0 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    countArr[xx][yy] = countArr[curX][curY] + 1;
                    Axis2 newAxis = new Axis2();
                    newAxis.x = xx;
                    newAxis.y = yy;
                    queue.offer(newAxis);
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
                if(i==0 || j==0 || i == N+1 || j==M+1) {
                    map[i][j] = 1;
                }
                 else {
                    map[i][j] = sc.nextInt();
                }
            }
        }

        FindMaze1 m = new FindMaze1();
        m.map = map;
        m.check = new boolean[1001][1001];
        m.countArr = new int[1001][1001];
        m.BFS(N, 1);

        System.out.println(m.countArr[1][M]);
    }
}
