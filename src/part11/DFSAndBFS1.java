package part11;

import java.util.*;

public class DFSAndBFS1 {
    Map<Integer, List<Integer>> graph;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] check;
    boolean[] visited;
    public void DFS(int x) {
        visited[x] = true;
        System.out.print(x+ " ");
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                DFS(y);
            }
        }
    }

    public void BFS() {
        queue.offer(0);
        check[0] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            check[current] = true;
            for(int i=0; i<graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if(!check[next]) {
                    queue.offer(next);
                    check[next] = true;
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
        DFSAndBFS1 m = new DFSAndBFS1();
        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }
        m.graph = graph;
        m.visited = new boolean[1001];
        m.check = new boolean[1001];

        m.DFS(0);
        System.out.println();
        m.BFS();


    }
}
