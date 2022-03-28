package part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Tree1 {
    int parent;
}

public class LowestCommonAncestor {
    Tree1[] tree = new Tree1[1000];
    List<Integer> parentList = new ArrayList<>();
    boolean[] check = new boolean[1000];
    public void findParent(int x) {
        if(check[tree[x].parent]) {
            parentList.add(tree[x].parent);
        } else {
            check[tree[x].parent] = true;
            findParent(tree[x].parent);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");

        int n = Integer.parseInt(strArr[0]);
        int X = Integer.parseInt(strArr[1]);
        int Y = Integer.parseInt(strArr[2]);

        String[][] inputArr = new String[n-1][2];
        Tree1[] tree = new Tree1[1000];
        for(int i=0; i<1000; i++) {
            tree[i] = new Tree1();
        }

        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            tree[Integer.parseInt(inputArr[i][1])].parent = Integer.parseInt(inputArr[i][0]);
        }

        LowestCommonAncestor m = new LowestCommonAncestor();
        m.tree = tree;
        Arrays.fill(m.check, false);

        m.findParent(X);
        m.findParent(Y);
        System.out.println(m.parentList.get(m.parentList.size()-1));
    }
}
