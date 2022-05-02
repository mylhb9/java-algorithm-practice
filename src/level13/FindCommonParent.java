package level13;

// 문제: 공통 조상 찾기
// 두 노드의 가장 가까운 공통 조상을 찾는 프로그램을 작성

// 입력: 첫 번째 줄에 트리 노드 개수 n, 두 노드 X, Y 의 번호가 주어진다.
// 각 줄은 2개의 숫자 a, b,로 이루어지고, a 는 b의 부모노드이다.
// 루트는 노드 0라고 가정한다

// 출력: 두 노드 X, Y의 공통조상을 출력한다.

import java.util.*;

class Tree1 {
    int parent;
}

public class FindCommonParent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] arr = new int[n-1][2];
        Tree1[] trees = new Tree1[n];
        for(int i=0; i<n-1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            trees[arr[i][1]] = new Tree1();
            trees[arr[i][1]].parent = arr[i][0];
        }

        List<Integer> XList = new ArrayList<>();
        List<Integer> YList = new ArrayList<>();
        while(true) {
            XList.add(trees[X].parent);
            if(trees[X].parent == 0) {
                break;
            }
            X = trees[X].parent;
        }

        while(true) {
            YList.add(trees[Y].parent);
            if(trees[Y].parent == 0) {
                break;
            }
            Y = trees[Y].parent;
        }

        int idx = XList.size()-1;
        int xidx = XList.size()-1;
        int yidx = YList.size()-1;
        while(xidx>=0 && yidx>=0) {
            if(XList.get(xidx) != YList.get(yidx)) {
                break;
            } else {
                idx = xidx;
            }
            xidx--;
            yidx--;
        }
        System.out.println(XList.get(idx));

    }
}
