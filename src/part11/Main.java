package part11;

// 문제: N x M의 지도가 주어진다.
// (N-1, 0) 에서 출발하여 (0, M-1) 까지 도착하는 최단거리
// 목수는 도끼 하나를 갖고 있고 이 도끼를 이용하여 1개만 부술 수 있다

import java.util.*;

class Axis1 {
    int x;
    int y;
}

public class Main {
    boolean[][] check = new boolean[1005][1005];
    Queue<Axis1> queue = new LinkedList<>();
    Integer[] dx = {1, -1, 0, 0};
    Integer[] dy = {0, 0, 1, -1};
    Integer[][] map = new Integer[1005][1005];

    public void BFS(int x, int y, Integer[][] answer) {
        check[x][y] = true;
        Axis1 axis = new Axis1();
        axis.x = x;
        axis.y = y;
        queue.offer(axis);
        while(!queue.isEmpty()) {
            Axis1 current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            for(int i=0; i<4; i++) {
                int xx = currentX+dx[i];
                int yy = currentY+dy[i];

                if(map[xx][yy] == 0 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    answer[xx][yy] = answer[currentX][currentY] + 1;
                    Axis1 newAxis = new Axis1();
                    newAxis.x = xx;
                    newAxis.y = yy;
                    queue.offer(newAxis);
                }
            }
        }
    }

    public static void main(String[] args) {
// 입력: 지도의 세로길이 N과 지도의 가로길이 M이 주어진다. (1 <=N, M<= 1000)
// 둘째 줄부터 지도의 정보가 주어진다. 0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분이다
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        String[][] inputArr = new String[N][M];
        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        Integer[][] map = new Integer[N+2][M+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                if(i == 0 || i == N+1 || j == 0 || j == M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = Integer.parseInt(inputArr[i-1][j-1]);
                }
            }
        }

        Main m = new Main();
        m.map = map;
        Integer[][] answer1 = new Integer[1005][1005];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                m.check[i][j] = false;
                answer1[i][j] = 0;
            }
        }

        m.BFS(N, 1, answer1);

        Integer[][] answer2 = new Integer[1005][1005];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                m.check[i][j] = false;
                answer2[i][j] = 0;
            }
        }

        m.BFS(1, M, answer2);
        Integer[][] answer = new Integer[1005][1005];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(map[i][j] == 1) {

                }
            }
        }

// 출력: 목수가 (N-1, 0) 에서 출발하여 (0, M-1) 까지 이동하는데,
// 필요한 최단거리를 출력한다. 목수는 미로를 항상 탈출할 수 없다고 가정한다.
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
