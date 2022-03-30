package part8;

import java.util.List;
import java.util.Scanner;

class Node<T> {
    Node<T> parentNode;
    Node<T> childNode;
    int count = 0;
    int value;

}


public class Main {
    Node<Integer> root = null;
    public void findHeight(Node<Integer> node) {
        if(node.parentNode == null) {
            System.out.println();
        } else {

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");

        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);

        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }

    }
}
