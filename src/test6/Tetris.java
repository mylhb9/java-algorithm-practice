package test6;

import java.util.*;

public class Tetris {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //   C
        //R

        List<Integer> checkPosition = new ArrayList<>();
        int C = sc.nextInt();
        int R = sc.nextInt();
        int[][] table = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<C; i++) {
            boolean check = false;
            for(int j=0; j<R; j++) {
                if(table[j][i] == 1) {
                    checkPosition.add(j);
                    check = true;
                    break;
                }
            }
            if(!check) {
                checkPosition.add(R);
            }
        }



//        System.out.println(checkPosition);

        List<Integer> needCheckList = new ArrayList<>();
        for(int i=0; i<C; i++) {
            if(checkPosition.get(i) >= 4) {
                needCheckList.add(i);
            }
        }

//        System.out.println(needCheckList);

        List<Integer> countList = new ArrayList<>();
        for(int i=0; i<needCheckList.size(); i++) {
            int count = 0;
            for(int k=0; k<4; k++) {
                int sum = 0;
                for(int j=0; j<C; j++) {
                    sum += table[checkPosition.get(needCheckList.get(i))-k-1][j];
                }
                if(sum >= C-1) {
                    count++;
                }
            }
            countList.add(count);
        }

        int max = -987987987;
        int idx = -1;
        for(int i=0; i<countList.size(); i++) {
            if(max < countList.get(i)) {
                max = countList.get(i);
                idx = i;
            }
        }

        if(needCheckList.size() == 0 || max == 0) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(needCheckList.get(idx)+1 + " " + max);
        }

        sc.close();
    }
}
