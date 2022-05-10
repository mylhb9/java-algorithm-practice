package level19;

import java.util.*;

public class DFSAndBFS {
    boolean[] visitedB = new boolean[1001];
    boolean[] visitedD = new boolean[1001];
    Map<Integer, List<Integer>> graph;
    public void DFS(int x) {
        visitedD[x] = true;
        System.out.print(x+" ");
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visitedD[y]) {
                DFS(y);
            }
        }
    }
    public void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visitedB[x] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for(int i=0; i<graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if(!visitedB[next]) {
                    queue.offer(next);
                    visitedB[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }

        DFSAndBFS m = new DFSAndBFS();
        m.graph = graph;
        m.DFS(0);
        System.out.println();
        m.BFS(0);
        sc.close();
    }
}
