package part10;

import java.util.*;

public class JudgeBinaryGraph4 {
    boolean[] visited = new boolean[1001];
    boolean[] checks = new boolean[1001];
    boolean check = false;
    Map<Integer, List<Integer>> graph;
    public void DFS(int x) {
        visited[x] = true;

        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                checks[y] = !checks[x];
                DFS(y);
            } else {
                if(checks[y] == checks[x]) {
                    check = true;
                    return;
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

        JudgeBinaryGraph4 m = new JudgeBinaryGraph4();
        m.graph = graph;
        m.DFS(1);
        if(m.check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }
}
