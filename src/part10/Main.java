package part10;

import java.util.*;

public class Main {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] arr;
    public int DFS(int x, int y) {
        int count = 0;
        arr[x][y] = 0;
        count++;
        for(int i=0; i<4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];
            if(arr[xx][yy] == 1) {
                count += DFS(xx, yy);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[][] strArr = new String[N][N];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split("");
        }

        int[][] arr = new int[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<N+2; j++) {
                if(i==0 || i==N+1 || j==0 || j==N+1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = Integer.parseInt(strArr[i-1][j-1]);
                }
            }
        }
        Main m = new Main();
        m.arr = arr;
        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(arr[i][j] == 1) {
                    countList.add(m.DFS(i, j));
                }
            }
        }
        int size = countList.size();
        System.out.println(size);
        Collections.sort(countList);
        for(int i=0;i<size; i++) {
            System.out.println(countList.get(i));
        }
    }
}
