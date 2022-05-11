package level19;

import java.util.*;
class Vertex {
    int x;
    int y;
}

public class EscapeMaze {
    int nn, mm;
    int[][] map;
    boolean[][] visited = new boolean[1005][1005];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public void BFS(int x, int y, int[][] answer) {
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = new Vertex();
        vertex.x = x;
        vertex.y = y;
        visited[x][y] = true;
        queue.offer(vertex);
        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            for(int i=0; i<4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];
                if(xx >= 1 && yy >= 1 && xx <= nn && yy <= mm && !visited[xx][yy]) {
                    answer[xx][yy] = answer[current.x][current.y] + 1;
                    visited[xx][yy] = true;
                    if(map[xx][yy] == 0) {
                        Vertex newVertex = new Vertex();
                        newVertex.x = xx;
                        newVertex.y = yy;
                        queue.offer(newVertex);
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
                if(i==0 || i==N+1 || j==0 || j==M+1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = sc.nextInt();
                }
            }
        }
        EscapeMaze m = new EscapeMaze();
        m.nn = N;
        m.mm = M;
        m.map = map;
        int[][] answer1 = new int[N+2][M+2];
        m.BFS(N, 1, answer1);
        int[][] answer2 = new int[N+2][M+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                m.visited[i][j] = false;
            }
        }
        m.BFS(1, M, answer2);
        int[][] answer = new int[N+2][M+2];
        int min = 987987987;
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(answer1[i][j] != 0 && answer2[i][j] != 0) {
                    answer[i][j] = answer1[i][j] + answer2[i][j];
                    min = Math.min(min, answer[i][j]);
                }
            }
        }
        System.out.println(min);
        sc.close();
    }
}
