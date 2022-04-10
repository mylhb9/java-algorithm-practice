package part11;

import java.util.*;

// 문제: N x M 지도가 주어진다. (N-1. 0) 에서 출발해서 (0, M-1) 까지 도착하는 최단거리를 출력하는 프로그램을 작성
// S 에서 E 까지 가는 최단거리는 22 이다
class Axis {
    int x;
    int y;
}

public class FindMaze {
    Integer[] dx = {1, -1, 0, 0};
    Integer[] dy = {0, 0, 1, -1};
    Integer[][] map;
    Integer[][] answer;
    Queue<Axis> queue = new LinkedList<>();
    boolean[][] check;

    public void BFS(int x, int y) {
        check[x][y] = true;
        Axis axis = new Axis();
        axis.x = x;
        axis.y = y;

        queue.offer(axis);

        while(!queue.isEmpty()) {
            Axis current = queue.poll();

            int curX = current.x;
            int curY = current.y;

            for(int i=0; i<4; i++) {
                int xx = curX + dx[i];
                int yy = curY + dy[i];

                if(map[xx][yy] == 0 && !check[xx][yy]) {
                    check[xx][yy] = true;
                    answer[xx][yy] = answer[curX][curY] + 1;
                    Axis newAxis = new Axis();
                    newAxis.x = xx;
                    newAxis.y = yy;
                    queue.offer(newAxis);
                }
            }

        }
    }

    public static void main(String[] args) {
// 입력: 첫째 줄에 지도의 세로길이 N과 지도의 가로길이 M이 주어진다
// 둘째 줄부터 지도의 정보가 주어진다.
// 0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분
        Scanner sc = new Scanner(System.in);
        String[] strArr= sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        String[][] inputArr = new String[N][M];
        Integer[][] map = new Integer[N+2][M+2];
        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                if(i == 0 || i == N+1 || j ==0 || j== M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = Integer.parseInt(inputArr[i-1][j-1]);
                }
            }
        }
        FindMaze m = new FindMaze();
        m.check = new boolean[1005][1005];
        m.map = map;
        m.answer = new Integer[N+2][M+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                m.check[i][j] = false;
                m.answer[i][j] = 0;
            }
        }
        m.BFS(N, 1);
        System.out.println(m.answer[1][M]);
    }
}
