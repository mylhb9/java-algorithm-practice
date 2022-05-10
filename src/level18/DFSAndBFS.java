package level18;

import java.util.*;

public class DFSAndBFS {
    Map<Integer, List<Integer>> graph;
    boolean[] visitedD = new boolean[1001];
    boolean[] visitedB = new boolean[1001];

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
            int y = queue.poll();
            System.out.print(y + " ");
            for(int i=0; i<graph.get(y).size(); i++) {
                int z = graph.get(y).get(i);
                if(!visitedB[z]) {
                    queue.offer(z);
                    visitedB[z] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<=N; i++) {
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
