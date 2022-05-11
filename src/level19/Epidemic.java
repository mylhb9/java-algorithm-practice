package level19;

import java.util.*;

public class Epidemic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(K);
        visited[K] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current*2 <= N && !visited[current*2]) {
                queue.offer(current*2);
                visited[current*2] = true;
            }
            if(current/3 >=1 && !visited[current/3]) {
                queue.offer(current/3);
                visited[current/3] = true;
            }
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(visited[i]) {
                count++;
            }
        }
        System.out.println(N-count);
        sc.close();
    }
}
