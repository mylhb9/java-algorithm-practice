package part10;

import java.util.*;

public class TwoColoringPage2 {
    boolean[] visited;
    boolean[] checks;
    boolean check = false;
    Map<Integer, List<Integer>> graph;
    public void DFS(int x) {
        visited[x] = true;

        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                if(checks[x]) {
                    checks[y] = false;
                } else {
                    checks[y] = true;
                }
                DFS(y);
            } else {
                if(checks[y] == checks[x]) {
                    check = true;
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
        for(int i=0; i<=N-1; i++) {
            graph.put(i, new ArrayList<>());
        }

        String[][] inputArr = new String[M][2];
        for(int i=0; i<M; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }
        TwoColoringPage2 m = new TwoColoringPage2();
        m.visited = new boolean[10001];
        m.checks = new boolean[10001];
        m.checks[Integer.parseInt(inputArr[0][0])] = false; // 수정필요

        m.graph = graph;
        m.DFS(Integer.parseInt(inputArr[0][0]));

        if(m.check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}