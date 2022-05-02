package level12;

// 문제: 전염병
// 마을은 1번부터 N번까지 번호가 매겨져있다.
// i 번째 마을에서 출발하면 i*2 번쨰 마을에 갈 수 있고
// i / 3 번째 마을에도 갈 수 있다.
// i 번째 마을에 전염병이 감염되면 위의 두 마을에 전염병이 옮겨진다.
// K번 마을이 가장 처음으로 전염병이 돌기 시작하였을 때, 전염병이 돌지 않는 마을의 개수 구하는 프로그램

// 입력: 첫째 줄에 전체 마을의 개수 N과 전염병이 돌기 시작한 마을번호 K가 주어진다.

// 출력: 전염병이 돌지 않는 마을의 개수를 출력

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Epidemic {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;
        boolean[] visited = new boolean[N+1];
        Arrays.fill(visited, false);

        queue.offer(K);
        visited[K] = true;
        while(!queue.isEmpty()) {
            K = queue.poll();
            if(K*2<=N && !visited[K*2]) {
                visited[K*2] = true;
                queue.offer(K*2);
                count++;
            }
            if(K/3>=1 && !visited[K/3]) {
                visited[K/3] = true;
                queue.offer(K/3);
                count++;
            }
        }
        System.out.println(N-1-count);
    }
}
