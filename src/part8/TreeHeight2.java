package part8;

import java.util.*;

// 문제: 트리의 높이는 루트로부터 가장 멀리 떨어진 노드와의 거리로 정의됨
// 트리가 주어질 때 트리의 높이를 출력하는 프로그램을 작성
public class TreeHeight2 {
    boolean[] visited;
    List<Integer> countList = new ArrayList<>();
    Map<Integer, List<Integer>> graph;
    int count = 0;
    public void DFS(int x) {
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) {
                count++;
                countList.add(count);
                DFS(y);
                count--;
            }
        }
    }

    public static void main(String[] args) {
// 입력: 첫 번째 줄에 트리의 노드 개수 n, 루트노드의 번호 r이 주어짐
// (1<=n<=100), (0<=r<=n-1)
// 두 번째 줄부터 간선 정보가 주어진 노드의 번호는 0~n-1
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<=n-1; i++) {
            graph.put(i, new ArrayList<>());
        }

        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }

        TreeHeight2 m = new TreeHeight2();
        m.visited = new boolean[n];
        m.graph = graph;
        m.DFS(r);

// 출력: 트리의 높이를 출력한다.
        int max = 0;
        for(int i=0; i<m.countList.size(); i++) {
            max = Math.max(max, m.countList.get(i));
        }
        System.out.println(max);
    }
}
