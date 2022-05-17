package level20;

import java.util.*;

public class Party {
    Map<Integer, List<Integer>> graph;
    Map<Integer, List<Integer>> costs;
    int N;
    public int[] dijkstra(int start) {
        boolean[] check = new boolean[1001];
        int[] table = new int[1001];
        for(int i=1; i<=N; i++) {
            table[i] = 987987987;
        }

        table[start] = 0;

        for(int i=0; i<N; i++) {
            int min = 987987987;
            int minIdx = -1;

            for(int j=1; j<=N; j++) {
                if(!check[j] && table[j] < min) {
                    min = table[j];
                    minIdx = j;
                }
            }

            check[minIdx] = true;

            for(int j=0; j<graph.get(minIdx).size(); j++) {
                int node = graph.get(minIdx).get(j);
                int weight = costs.get(minIdx).get(j);
                if(table[node] > table[minIdx] + weight) {
                    table[node] = table[minIdx] + weight;
                }
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 정점의 개수
        int N = sc.nextInt();
        // 간선의 개수
        int M = sc.nextInt();
        // 철수의 집 번호
        int K = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> costs = new HashMap<>();
        Map<Integer, List<Integer>> revGraph = new HashMap<>();

        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
            costs.put(i, new ArrayList<>());
            revGraph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(b);
            costs.get(a).add(c);
            revGraph.get(b).add(a);
        }

        Party m = new Party();
        m.graph = graph;
        m.costs = costs;
        m.N = N;


        int[] table1 = new int[1001];
        int[] table2 = new int[1001];
        table1 = m.dijkstra(K);
        m.graph = revGraph;
        table2 = m.dijkstra(K);

    }
}
