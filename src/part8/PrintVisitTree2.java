package part8;

import java.util.Scanner;

class Tree4 {
    int left;
    int right;
}

public class PrintVisitTree2 {
    Tree4[] tree;
    public void front(int x) {
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x + " ");
        } else {
            System.out.print(x+ " ");
            if(tree[x].left != -1) {
                front(tree[x].left);
            }

            if(tree[x].right != -1) {
                front(tree[x].right);
            }
        }

    }

    public void middle(int x) {
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x + " ");
        } else {
            if(tree[x].left != -1) {
                middle(tree[x].left);
            }

            System.out.print(x+ " ");

            if(tree[x].right != -1) {
                middle(tree[x].right);
            }
        }

    }

    public void back(int x) {
        if(tree[x].left == -1 && tree[x].right == -1) {
            System.out.print(x + " ");
        } else {
            if(tree[x].left != -1) {
                back(tree[x].left);
            }



            if(tree[x].right != -1) {
                back(tree[x].right);
            }

            System.out.print(x+ " ");
        }

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[][] strArr = new String[n][3];
        PrintVisitTree2 m = new PrintVisitTree2();
        Tree4[] tree = new Tree4[n+1];
        for(int i=0; i<n; i++) {
            tree[i] = new Tree4();
        }

        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine().split(" ");
            tree[Integer.parseInt(strArr[i][0])].left = Integer.parseInt(strArr[i][1]);
            tree[Integer.parseInt(strArr[i][0])].right = Integer.parseInt(strArr[i][2]);
        }

        m.tree = tree;


        m.front(0);
        System.out.println();
        m.middle(0);
        System.out.println();
        m.back(0);



    }
}
// 전위순회: 0 1 3 4 2 5
// 중위순회: 3 1 4 0 2 5
// 후위순회: 3 4 1 5 2 0