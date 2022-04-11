package part11;

// 문제: N x M의 지도가 주어진다.
// (N-1, 0) 에서 출발하여 (0, M-1) 까지 도착하는 최단거리
// 목수는 도끼 하나를 갖고 있고 이 도끼를 이용하여 1개만 부술 수 있다

import java.util.Scanner;

public class EscapeMaze {
    boolean[][] check;
    public void BFS(int x, int y) {
        check[x][y] = true;
        

    }
    public static void main(String[] args) {
// 입력: 지도의 세로길이 N과 지도의 가로길이 M이 주어진다. (1 <=N, M<= 1000)
// 둘째 줄부터 지도의 정보가 주어진다. 0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분이다
        Scanner sc = new Scanner(System.in);




// 출력: 목수가 (N-1, 0) 에서 출발하여 (0, M-1) 까지 이동하는데,
// 필요한 최단거리를 출력한다. 목수는 미로를 항상 탈출할 수 없다고 가정한다.

    }
}
