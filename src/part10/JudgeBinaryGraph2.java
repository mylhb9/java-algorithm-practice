package part10;

import java.util.*;

// 문제: 이분 그래프란, 정점을 크게 두 집합으로 나눌 수 있는 그래프
// 같은 집합에 속한 정점끼리는 간선이 존재해서는 안됨
// 그래프가 입력으로 주어질 떄, 이 그래프가 이분 그래프인지 판별하는 프로그램을 만들어라
public class JudgeBinaryGraph2 {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    boolean[] checks;
    boolean check = false;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                checks[y] = !checks[x];
                DFS(y);
            } else {
                if(checks[x] == checks[y]) {
                    check = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        // 입력: 정점의 개수 N(2<= N <= 1000)  간선의 개수 M(N-1<=M<=100,000) 이 주어짐
        // 각 줄은 두 개의 숫자 a, b로 이루어져 있으며, 이는 정점 a(1<=a)와 b(b<=N)가 연결되어 있다는 의미
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

        JudgeBinaryGraph2 m = new JudgeBinaryGraph2();
        m.graph = graph;
        m.visited = new boolean[1005];
        m.checks = new boolean[1005];
        m.DFS(Integer.parseInt(inputArr[0][0]));
        // 출력: 주어진 그래프가 이분 그래프 이면 Yes, 아니면 No 를 출력한다.

        if(m.check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
