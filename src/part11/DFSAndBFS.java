package part11;

import java.util.*;

public class DFSAndBFS {
    boolean[] check;
    boolean[] visited;
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, List<Integer>> graph;

    void DFS(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                DFS(y);
            }
        }
    }


    void BFS(int a) {
        queue.offer(a);
        check[a] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
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

        String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<N; i++) {
            graph.put(i, new ArrayList<>());
        }

        String[][] inputArr = new String[M][2];
        for(int i=0; i<M; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }

        DFSAndBFS m = new DFSAndBFS();
        m.check = new boolean[2000];
        Arrays.fill(m.check, false);
        m.visited = new boolean[2000];
        m.graph = graph;
        m.DFS(0);
        System.out.println();
        m.BFS(0);
    }
}
