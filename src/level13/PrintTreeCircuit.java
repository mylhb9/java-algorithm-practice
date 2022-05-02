package level13;

// 문제: 트리 순회 결과 출력하기
// 루트가 0인 이진트리가 주어질 때, 이를 전위순회, 중위순회, 후위순회한 결과를 각각 출력

// 입력: 첫 번째 줄에 트리의 노드 개수 n이 주어짐
// 두 번째 줄부터 트리의 정보가 주어짐
// 각 줄은 3개의 숫자로 주어지며 루트노드 왼쪽자식노드 오른쪽자식노드이다
// 자식노드가 존재하지 않는 경우에는 -1로 주어진다

// 출력: 첫 번째 전위순회, 두 번쨰 중위순회, 세 번째 후위순회를 한 결과를 출력

import java.util.Scanner;

class Tree {
    int left;
    int right;
}

public class PrintTreeCircuit {
    Tree[] trees;

    public void front(int x) {
        if(trees[x].left == -1 && trees[x].right == -1) {
            System.out.print(x+ " ");
        } else {
            System.out.print(x + " ");
            if(trees[x].left != -1) {
                front(trees[x].left);
            }
            if(trees[x].right != -1) {
                front(trees[x].right);
            }
        }
    }

    public void mid(int x) {
        if(trees[x].left == -1 && trees[x].right == -1) {
            System.out.print(x+ " ");
        } else {

            if(trees[x].left != -1) {
                mid(trees[x].left);
            }
            System.out.print(x + " ");
            if(trees[x].right != -1) {
                mid(trees[x].right);
            }
        }
    }

    public void rear(int x) {
        if(trees[x].left == -1 && trees[x].right == -1) {
            System.out.print(x+ " ");
        } else {

            if(trees[x].left != -1) {
                rear(trees[x].left);
            }
            if(trees[x].right != -1) {
                rear(trees[x].right);
            }
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree[] trees = new Tree[n];
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            trees[idx] = new Tree();
            trees[idx].left = sc.nextInt();
            trees[idx].right = sc.nextInt();
        }
        PrintTreeCircuit m = new PrintTreeCircuit();
        m.trees = trees;
        m.front(0);
        System.out.println();
        m.mid(0);
        System.out.println();
        m.rear(0);
    }
}
