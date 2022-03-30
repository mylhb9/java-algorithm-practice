package part8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree2 {
    int parent;
}

public class TreeHeight {
    List<Integer> countList = new ArrayList<>();
    int r;
    int count = 1;
    Tree2[] tree = new Tree2[1000];


    void findHeight(int x) {
        if(x==r) {

        }
        else if(tree[x].parent == r) {
            countList.add(count);
            count = 1;
        } else {
            count++;
            findHeight(tree[x].parent);

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        Tree2[] tree = new Tree2[1000];
        for(int i=0; i<100; i++) {
            tree[i] = new Tree2();
        }
        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            tree[Integer.parseInt(inputArr[i][1])].parent = Integer.parseInt(inputArr[i][0]);
        }
        TreeHeight m = new TreeHeight();
        m.tree = tree;
        m.r = r;

        for(int i=0; i<n-1; i++) {
            m.findHeight(Integer.parseInt(inputArr[i][1]));
        }

        int height = 0;
        for(int i=0; i<m.countList.size(); i++) {
            height = Math.max(height, m.countList.get(i));
        }
        System.out.println(height);

    }
}
