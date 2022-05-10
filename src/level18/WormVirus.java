package level18;

import java.util.*;

public class WormVirus {
    boolean[] visited = new boolean[101];
    Map<Integer, List<Integer>> graph;
    int count = 0;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                count++;
                DFS(y);
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
        m.graph= graph;
        m.DFS(1);
        System.out.println(m.count);
    }
}
