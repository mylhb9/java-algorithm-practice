package level20;

import java.util.*;

public class ShortestDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] check = new boolean[10001];
        int[] table = new int[10001];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> weight = new HashMap<>();

        for(int i=0; i<N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            weight.put(a, 1);
            graph.get(b).add(a);
            weight.put(b, 1);
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        for(int i=0; i<N; i++) {
            table[i] = 987987987;
        }

        table[start] = 0;

        for(int i=0; i<N; i++) {
            int min = 987987987;
            int minIdx = -1;

            for(int j=0; j<N; j++) {
                if(!check[j] && min > table[j]) {
                    min = table[j];
                    minIdx = j;
                }
            }

            check[minIdx] = true;
            for(int j=0; j<graph.get(minIdx).size(); j++) {
                int node = graph.get(minIdx).get(j);
                int cost = weight.get(minIdx);

                if(table[node] > table[minIdx] + cost) {
                    table[node] = table[minIdx] + cost;
                }
            }
        }
        System.out.println(table[end]);
    }
}
