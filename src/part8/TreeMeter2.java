package part8;

import java.util.*;

public class TreeMeter2 {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int count = 0;
    int end;
    boolean check = false;
    public void DFS(int x) {
        if(check) {
            return;
        }
        visited[x] = true;
        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y] && y!=end) {
                count++;
                DFS(y);
                count--;
            } else if(y==end) {
                count++;
                System.out.println(count);
                check = true;

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int X = Integer.parseInt(strArr[1]);
        int Y = Integer.parseInt(strArr[2]);

        String[][] inputArr = new String[n-1][2];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<=n-1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            graph.get(Integer.parseInt(inputArr[i][0])).add(Integer.parseInt(inputArr[i][1]));
            graph.get(Integer.parseInt(inputArr[i][1])).add(Integer.parseInt(inputArr[i][0]));
        }
        TreeMeter2 m = new TreeMeter2();
        m.visited = new boolean[n];
        m.graph = graph;
        m.end = Y;
        m.DFS(X);

    }
}
