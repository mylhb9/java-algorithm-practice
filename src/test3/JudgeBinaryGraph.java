package test3;

import java.util.*;

// 문제: 이분 그래프란, 정점을 크게 두집합으로 나눌 수 있는 그래프
// 같은 집합에 속한 정점 사이에서는 간선이 존재하지않음
// 이분 그래프인지 판별하는 프로그램을 만들어라
public class JudgeBinaryGraph {
    boolean[] visited;
    Map<Integer, List<Integer>> graph;
    boolean[] checks;
    boolean flag = false;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                checks[y] = !checks[x];
                DFS(y);
            } else {
                if(checks[y] == checks[x]) {
                    flag= true;
                }
            }
        }
    }


    public static void main(String[] args) {
// 입력: 정점의 개수 N, 간선의 개수 M, 둘째 줄부터 간선의 정보가 주어짐
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");

        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }

        String[][] inputArr = new String[M][2];
        for(int i=0; i<M; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }

        JudgeBinaryGraph m = new JudgeBinaryGraph();
        m.graph = graph;
        m.visited = new boolean[N+1];
        m.checks = new boolean[N+1];
        m.DFS(Integer.parseInt(inputArr[0][0]));


        if(m.flag) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
