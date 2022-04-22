package test4;

import java.util.*;

public class DFSAndBFS {
    Map<Integer, List<Integer>> graph;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visitedB = new boolean[1001];
    boolean[] visitedD = new boolean[1001];
    public void DFS(int x) {
        visitedD[x] = true;
        System.out.print(x + " ");
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visitedD[y]) {
                DFS(y);
            }
        }
    }

    public void BFS() {
        queue.offer(0);
        visitedB[0] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            visitedB[current] = true;
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

        int[][] arr = new int[M][2];
        for(int i=0; i<M; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            graph.get(arr[i][0]).add(arr[i][1]);
            graph.get(arr[i][1]).add(arr[i][0]);
        }
        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }

        DFSAndBFS m = new DFSAndBFS();
        m.graph = graph;
        m.DFS(0);
        System.out.println();
        m.BFS();

    }
}
