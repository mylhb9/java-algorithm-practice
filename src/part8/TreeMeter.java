package part8;

import java.util.Scanner;

class Tree3 {
    int parentNode;
}

public class TreeMeter {
    int distanceNode;
    int count = 1;
    boolean check = false;
    Tree3[] tree = new Tree3[1005];
    boolean[] visit = new boolean[1005];
    Integer[] distanceArr = new Integer[1005];

    public void meter(int x) {
        if(x == 0) {

        } else if(tree[x].parentNode == 0 || visit[tree[x].parentNode] || tree[x].parentNode == distanceNode) {
            if(visit[tree[x].parentNode] || tree[x].parentNode == 0) {
                distanceArr[x] = count;
                count = 1;
            } else {
                check = true;
                distanceArr[x] = count;
                count = 1;
            }
        } else {
            count++;
            visit[x] = true;
            meter(tree[x].parentNode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int X = Integer.parseInt(strArr[1]);
        int Y = Integer.parseInt(strArr[2]);

        Tree3[] tree = new Tree3[1005];
        for(int i=0; i<tree.length; i++) {
            tree[i] = new Tree3();
        }
        String[][] inputArr = new String[n-1][2];
        for(int i=0; i<n-1; i++) {
            inputArr[i] = sc.nextLine().split(" ");
            tree[Integer.parseInt(inputArr[i][1])].parentNode = Integer.parseInt(inputArr[i][0]);
        }

        TreeMeter m = new TreeMeter();
        m.tree = tree;
        boolean isCheck = false;
        boolean[] visit = new boolean[1005];
        for(int i=0; i<visit.length; i++) {
            visit[i] = false;
        }
        m.visit = visit;
        Integer[] distanceArr = new Integer[1005];
        for(int i=0; i<distanceArr.length; i++) {
            distanceArr[i] = 0;
        }
        m.distanceArr = distanceArr;
        if(X > Y) {
            m.distanceNode = Y;
            m.meter(X);
            isCheck = true;
        } else if(X < Y) {
            m.distanceNode = X;
            m.meter(Y);
        } else {
            System.out.println(0);
            return;
        }
        int sum = 0;
        if(!m.check) {
            if(isCheck) {
                m.distanceNode = X;
                m.meter(Y);
            } else {
                m.distanceNode = Y;
                m.meter(X);
            }
        }
        for(int i=0; i<m.distanceArr.length; i++) {
            sum += m.distanceArr[i];
        }
        System.out.println(sum);
    }
}
