package level19;

import java.util.*;

public class WeirdCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] visited = new boolean[100000];
        int[] arr = new int[100000];
        int x = 1;


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] =true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current*2 < 100000 && !visited[current*2]) {
                arr[current*2] = arr[current] + 1;
                queue.offer(current*2);
                visited[current*2] =true;
            }
            if(current/3 >= 1 && !visited[current/3]) {
                arr[current/3] = arr[current] + 1;
                queue.offer(current/3);
                visited[current/3] =true;
            }
        }
        System.out.println(arr[N]);
        sc.close();
    }
}
