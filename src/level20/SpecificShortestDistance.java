package level20;

import java.util.*;

public class SpecificShortestDistance {

    int N;
    Map<Integer, List<Integer>> graph;
    Map<Integer, List<Integer>> costs;

    public int dijkstra(int start, int end) {
        int[] table = new int[1001];
        boolean[] check = new boolean[1001];
        for(int i=1; i<=N; i++) {
            table[i] = 987987987;
        }
        table[start] = 0;
        for(int i=1; i<=N; i++) {
            int min = 987987987;
            int minIdx = -1;

            for(int j=1; j<=N; j++) {
                if(!check[j] && min > table[j]) {
                    min = table[j];
                    minIdx = j;
                }
            }

            check[minIdx] = true;

            for(int j=0; j<graph.get(minIdx).size(); j++) {
                int node = graph.get(minIdx).get(j);
                int cost = costs.get(minIdx).get(j);

                if(table[node] > table[minIdx] + cost) {
                    table[node] = table[minIdx] + cost;
                }
            }
        }
        return table[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> costs = new HashMap<>();

        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
            costs.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            costs.get(a).add(c);
            costs.get(b).add(c);
        }

        int A = sc.nextInt();
        int B = sc.nextInt();
        SpecificShortestDistance m = new SpecificShortestDistance();
        m.graph = graph;
        m.costs = costs;
        m.N = N;

        int routeA = m.dijkstra(1, A) + m.dijkstra(A, B) + m.dijkstra(B, N);
        int routeB = m.dijkstra(1, B) + m.dijkstra(B, A) + m.dijkstra(A, N);
        System.out.println(Math.min(routeA, routeB));
    }
}
