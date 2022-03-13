package part4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int C = Integer.parseInt(strArr[0]);
        int R = Integer.parseInt(strArr[1]);

        String[][] stringTetrisSheet = new String[R][C];
        for(int i=0; i<R; i++) {
            stringTetrisSheet[i] = sc.nextLine().split(" ");
        }

        Integer[][] tetrisSheet = new Integer[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                tetrisSheet[i][j] = Integer.parseInt(stringTetrisSheet[i][j]);
            }
        }

        Integer[] index1 = new Integer[C];
        for(int j=0; j<C; j++) {
            for(int i=0; i<R; i++) {
                if(tetrisSheet[i][j] == 1) {
                    index1[j] = i;
                    break;
                }
            }
            if(index1[j] == null) {
                index1[j] = R;
            }
        }

        List<Integer> selectedIndex = new ArrayList<>();
        for(int i=0; i<C; i++) {
            if(index1[i] >= 4) {
                selectedIndex.add(i);
            }
        }
        List<Integer> countList = new ArrayList<>();
        for(int j=0; j<selectedIndex.size(); j++) {
            int count = 0;
            for(int i=index1[selectedIndex.get(j)]-1; i>=index1[selectedIndex.get(j)]-4; i--) {
                tetrisSheet[i][selectedIndex.get(j)] = 1;
            }
            for(int i=R-1; i>=0; i--) {
                int sum = 0;
                for(int k=0; k<C; k++) {
                    sum += tetrisSheet[i][k];
                }
                if(sum == C) {
                    count++;
                }
            }
            for(int i=index1[selectedIndex.get(j)]-1; i>=index1[selectedIndex.get(j)]-4; i--) {
                tetrisSheet[i][selectedIndex.get(j)] = 0;
            }
            countList.add(count);
        }

        int max = 0;
        int maxIdx= 0;
        for(int i=0; i<countList.size(); i++) {
            if(max < countList.get(i)) {
                max = countList.get(i);
                maxIdx = i;
            }
        }
        if(max == 0) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(selectedIndex.get(maxIdx)+1 + " " + max);
        }

    }
}
