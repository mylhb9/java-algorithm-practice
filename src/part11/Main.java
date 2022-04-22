package part11;

// 문제: 미로 찾기 문제에서 도끼를 하나 갖고 있는 목수가 한번 벽을 부술 수 있음

// 입력: 첫째 줄에 지도의 세로길이 N 가로길이 M이 주어진다.
// 0 은 이동할 수 있는 부분, 1은 이동할 수 없는 부분을 나타냄

// 출력: (N-1, 0) 에서 출발하여 (0, M-1) 까지 이동하는데 필요한 최단거리를 출력한다.
// 목수는 미로를 항상 탈출할 수 있다고 가정한다.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Axis3 {
    int x;
    int y;
}

public class Main {
    Queue<Axis3> queue = new LinkedList<>();
    boolean[][] check;
    int N, M;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] map;
    public void BFS(int x, int y, int[][] countArr) {
        Axis3 axis = new Axis3();
        axis.x = x;
        axis.y = y;
        queue.offer(axis);
        check[x][y] = true;
        countArr[x][y] = 0;
        while(!queue.isEmpty()) {
            Axis3 current = queue.poll();
            int curX = current.x;
            int curY = current.y;

            for(int i=0; i<4; i++) {
                int xx = curX + dx[i];
                int yy = curY + dy[i];

                if(xx >= 1 && yy >= 1 && xx<=N && yy <=M && !check[xx][yy]) {
                    check[xx][yy] = true;
                    countArr[xx][yy] = countArr[curX][curY] + 1;
                    if(map[xx][yy] == 0) {
                        Axis3 newAxis = new Axis3();
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
                if(i == 0 || i == N+1 || j==0 || j== M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = sc.nextInt();
                }
            }
        }
        Main m = new Main();
        m.map = map;
        m.N = N;
        m.M = M;
        m.check = new boolean[1001][1001];
        int[][] countArr1 = new int[1001][1001];
        m.BFS(N,1, countArr1);


        m.check = new boolean[1001][1001];
        int[][] countArr2 = new int[1001][1001];
        m.BFS(1,M, countArr2);


        int[][] countArr = new int[N+2][M+2];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                countArr[i][j] = countArr1[i][j] + countArr2[i][j];
            }
        }


        int min = 1000000;
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
