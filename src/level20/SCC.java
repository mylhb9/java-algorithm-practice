package level20;

import java.util.*;

public class SCC {
    int[] time = new int[1005];
    int[] order = new int[1005];
    int[] group = new int[1005];
    int clock = 1;
    int orderLen = 0;
    int groupCnt = 1;
    boolean[] check = new boolean[1005];
    boolean[] visited = new boolean[1005];
    Map<Integer, List<Integer>> graph;
    Map<Integer, List<Integer>> reverseGraph;

    public void getMyGroup(int node) {
        visited[node] = true;

        group[node] = groupCnt;
        for(int i=0; i<reverseGraph.get(node).size(); i++) {
            int newNode = reverseGraph.get(node).get(i);

            if(!visited[newNode]) {
                getMyGroup(newNode);
            }
        }
    }

    public void getTime(int node) {
        check[node] = true;

        for(int i=0; i<graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);
            if(!check[newNode]) {
                getTime(newNode);
            }
        }

        time[node] = clock;
        order[orderLen++] = node;
        clock++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> reverseGraph = new HashMap<>();

        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
            reverseGraph.put(i, new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        SCC m = new SCC();
        m.graph = graph;
        m.reverseGraph = reverseGraph;
        for(int i=1; i<=N; i++) {
            if(!m.check[i]) {
                m.getTime(i);
            }
        }

        for(int i=m.orderLen-1; i>=0; i--) {
            int node = m.order[i];
            if(!m.visited[node]) {
                m.getMyGroup(node);
                m.groupCnt++;
            }
        }
        System.out.println(m.groupCnt-1);
    }
}
