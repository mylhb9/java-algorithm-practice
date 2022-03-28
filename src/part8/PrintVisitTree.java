package part8;

import java.util.Scanner;

class Tree {
    int left;
    int right;

}

public class PrintVisitTree {
    Tree[] tree = new Tree[1000];
    void preOrder(int x) {
        // x를 루트로 하는 서브 트리를 전위 순회하여 출력하는 메소드
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x +" ");
        } else {
            System.out.print(x + " ");

            if(tree[x].left != -1) {
                preOrder(tree[x].left);
            }

            if(tree[x].right != -1) {
                preOrder(tree[x].right);
            }
        }
    }

    void inOrder(int x) {
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x +" ");
        } else {
            if(tree[x].left != -1) {
                inOrder(tree[x].left);
            }
            System.out.print(x +" ");
            if(tree[x].right != -1) {
                inOrder(tree[x].right);
            }
        }
    }

    void postOrder(int x) {
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x +" ");
        } else {
            if(tree[x].left != -1) {
                postOrder(tree[x].left);
            }
            if(tree[x].right != -1) {
                postOrder(tree[x].right);
            }
            System.out.print(x +" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[][] strArr = new String[n][3];

        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }


        Tree[] tree = new Tree[1000];
        for(int i=0; i<1000; i++) {
            tree[i] = new Tree();
        }
        for(int i=0; i<n; i++) {
            tree[Integer.parseInt(strArr[i][0])].left = Integer.parseInt(strArr[i][1]);
            tree[Integer.parseInt(strArr[i][0])].right = Integer.parseInt(strArr[i][2]);
        }

        PrintVisitTree m = new PrintVisitTree();
        m.tree = tree;
        m.preOrder(0);
        System.out.println();
        m.inOrder(0);
        System.out.println();
        m.postOrder(0);
    }
}
