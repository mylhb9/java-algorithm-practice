package level4;

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

        List<Integer> selectedCol = new ArrayList<>();
        List<Integer> selectedRow = new ArrayList<>();
        for(int j=0; j<C; j++) {
            for(int i=0; i<R; i++) {
                if(tetrisMap[i][j].equals("1")) {
                    if(i>=4) {
                        selectedCol.add(j);
                        selectedRow.add(i);
                    }
                    break;
                } else if(i==R-1) {
                    selectedCol.add(j);
                    selectedRow.add(R);
                }
            }
        }
        List<Integer> countList = new ArrayList<>();
        for(int k=0; k<selectedCol.size(); k++) {
            int count = 0;
            for(int i=selectedRow.get(k)-1; i>selectedRow.get(k)-5; i--) {
                tetrisMap[i][selectedCol.get(k)] = "1";
            }
            for(int i=R-1; i>=0; i--) {
                boolean check = false;
                for(int j=0; j<C; j++) {
                    if(tetrisMap[i][j].equals("0")) {
                        check = true;
                    }
                }
                if(!check) {
                    count++;
                }
            }
            countList.add(count);
            for(int i=selectedRow.get(k)-1; i>selectedRow.get(k)-5; i--) {
                tetrisMap[i][selectedCol.get(k)] = "0";
            }
        }
        int max = 0;
        int idx = 0;
        for(int i=0; i< countList.size(); i++) {
            if(max < countList.get(i)) {
                max = countList.get(i);
                idx = i;
            }
        }
        if(max == 0) {
            System.out.println(0+ " " + 0);
        } else {
            System.out.println(selectedCol.get(idx)+1 + " " + max);
        }
    }
}