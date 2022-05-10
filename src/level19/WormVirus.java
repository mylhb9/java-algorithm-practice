package level19;

import java.util.*;

public class WormVirus {
    Map<Integer, List<Integer>> graph;
    boolean[] visited = new boolean[101];
    int count = 0;
    public void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i=0; i<graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if(!visited[next]) {
                    count++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        WormVirus m = new WormVirus();
        m.graph = graph;
        m.BFS(1);
        System.out.println(m.count);
    }
}
