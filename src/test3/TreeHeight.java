package test3;


import java.util.*;

// 문제: 트리의 높이를 구해라
public class TreeHeight {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int count = 0;
    List<Integer> countList = new ArrayList<>();
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
// 입력: n (트리의 노드 개수), r(루트 노드의 번호)
// 두번쨰 줄부터 간선정보가 주어짐
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

        TreeHeight m = new TreeHeight();
        m.visited = new boolean[n];
        m.graph = graph;
        m.DFS(r);




// 출력: 트리의 높이를 출력

        int max = 0;
        for(int i=0; i< m.countList.size(); i++) {
            max = Math.max(max, m.countList.get(i));
        }
        System.out.println(max);
    }
}
