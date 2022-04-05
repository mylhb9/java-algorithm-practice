package part10;


import java.util.*;

// 문제: 2색 칠하기란, 두 조건을 만족하면서 정점을 모두 색칠할 수 있는지 묻는 문제이다.
// 인접한 두 정점은 색깔이 다르다. 그래프가 주어질 때, 2색 칠하기가 가능한지 출력하는 프로그램을 작성

// 입력: 정점의 개수 N 과 간선의 개수 M 이 주어진다 (1<=N<=10000, 1=M<=100000)
// 둘째 줄부터 간선의 정보가 주어진다. 각줄은 두 개의 숫자 a, b 로 이루어져있으며 연결됐다는 의미이다.
public class TwoColoringPage {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    boolean color = false;
    boolean[] check;

    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                check[y] = !check[x];
                DFS(y);
            } else {
                if(check[y] == check[x]) {
                    color = true;
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
        TwoColoringPage m = new TwoColoringPage();
        m.graph = graph;
        m.visited = new boolean[10001];
        m.check = new boolean[10001];
        m.check[0] = false;
        m.DFS(0);
        if(m.color) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
