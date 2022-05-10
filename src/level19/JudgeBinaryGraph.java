package level19;

import java.util.*;

public class JudgeBinaryGraph {
    boolean[] visited = new boolean[10001];
    boolean[] checked = new boolean[10001];
    boolean check = false;
    Map<Integer, List<Integer>> graph;
    public void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.offer(x);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i=0; i<graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if(!visited[next]) {
                    checked[next] = !checked[current];
                    queue.offer(next);
                    visited[next]= true;
                } else {
                    if(checked[next] == checked[current]) {
                        check = true;
                    }
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
        JudgeBinaryGraph m = new JudgeBinaryGraph();
        m.graph = graph;
        m.BFS(1);
        if(m.check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        sc.close();
    }
}
