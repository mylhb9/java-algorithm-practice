package level18;

import java.util.*;

public class ColoringPage {
    boolean[] visited = new boolean[10001];
    boolean[] color = new boolean[10001];
    boolean check = false;
    Map<Integer, List<Integer>> graph;
    public void DFS(int x) {
        if(check) {
            return;
        }
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                color[y] = !color[x];
                DFS(y);
            } else {
                if(color[y] != !color[x]) {
                    check = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ColoringPage m = new ColoringPage();
        m.graph = graph;
        m.DFS(0);
        if (!m.check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
