package part8;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 트리의 노드 X에 대해 조상을 정의할 수 있다.
// 조상이란 루트까지 올라가는 중에 만나는 모든 노드를 말한다.
// 두 노드 X, Y 의 공통 조상이란 X Y 가 공통으로 갖는 조상을 말한다.
// 가장 가까운 공통 조상을 찾는 프로그램을 작성하라
class Tree5 {
    int parent;
}

public class LowestCommonAncestor2 {
    Tree5[] tree;
    boolean[] visited;
    boolean check1 = false;
    boolean check2 = false;
    void findParent1(int x) {
        if(check1) {
            return;
        }
        if(!visited[tree[x].parent]) {
            visited[tree[x].parent] = true;
            findParent1(tree[x].parent);
        }  else {
            check1 = true;
        }
    }

    void findParent2(int x) {
        if(check2) {
            return;
        }
        if(!visited[tree[x].parent]) {
            visited[tree[x].parent] = true;
            findParent2(tree[x].parent);
        }  else {
            System.out.println(tree[x].parent);
            check2 = true;
        }
    }

    public static void main(String[] args) {
        // 입력: 트리의 노드 개수 n, 두 노드 X Y 번호가 주어짐
        // 두번째줄부터 트리의 간선정보가 주어짐
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int X = Integer.parseInt(strArr[1]);
        int Y = Integer.parseInt(strArr[2]);

        String[][] inputArr = new String[n][2];
        Tree5[] tree = new Tree5[n];
        for(int i=0; i<n; i++) {
            tree[i] = new Tree5();
        }

        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            tree[Integer.parseInt(inputArr[i][1])].parent = Integer.parseInt(inputArr[i][0]);
        }

        LowestCommonAncestor2 m = new LowestCommonAncestor2();
        m.visited = new boolean[n];
        Arrays.fill(m.visited, false);
        m.tree = tree;




        m.findParent1(X);
        m.findParent2(Y);

    }
}
