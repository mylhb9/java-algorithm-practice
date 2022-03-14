package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int C = Integer.parseInt(strArr[0]);
        int R = Integer.parseInt(strArr[1]);

        String[][] tetrisMap = new String[R][C];
        for(int i=0; i<R; i++) {
            tetrisMap[i] = sc.nextLine().split(" ");
        }
        Integer[][] tetris = new Integer[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                tetris[i][j] = Integer.parseInt(tetrisMap[i][j]);
            }
        }

        Integer[] find1 = new Integer[C];
        for(int j=0; j<C; j++) {
            for(int i=0; i<R; i++) {
                if(tetris[i][j]==1) {
                    find1[j] = i;
                    break;
                }
            }
            if(find1[j] == null) {
                find1[j] = R;
            }
        }

        List<Integer> selectedCol = new ArrayList<>();
        for(int i=0; i<C; i++) {
            if(find1[i]>=4) {
                selectedCol.add(i);
            }
        }
        List<Integer> countList = new ArrayList<>();
        for(int i=0; i<selectedCol.size(); i++) {
            for(int j=find1[selectedCol.get(i)]-1; j>=0; j--) {
                tetris[j][selectedCol.get(i)] = 1;
            }

            int count = 0;
            for(int j=0; j<R; j++) {
                int sum = 0;
                for(int a=0; a<C; a++) {
                    sum += tetris[j][a];
                }
                if(sum==C) {
                    count++;
                }
            }
            countList.add(count);
            for(int j=find1[selectedCol.get(i)]-1; j>=0; j--) {
                tetris[j][selectedCol.get(i)] = 0;
            }
        }
        int max = 0;
        int index = 0;
        for(int i=0; i<countList.size(); i++) {
            if(max < countList.get(i)) {
                max = countList.get(i);
                index = i;
            }
        }

        if(max == 0) {
            System.out.println(0+ " " + 0);
        } else {
            System.out.println(selectedCol.get(index)+1 + " " + max);
        }
    }
}
