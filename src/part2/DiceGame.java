package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        List<Integer> prices = new ArrayList<>();

        String[][] strArr = new String[N][3];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        Integer[][] intArr = new Integer[N][3];
        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }
        for(int i=0; i<N; i++) {
            if(intArr[i][0] == intArr[i][1] && intArr[i][1] == intArr[i][2] && intArr[i][2] == intArr[i][0]) {
                prices.add(10000 + intArr[i][0] * 1000);
            } else if(intArr[i][0] == intArr[i][1]) {
                prices.add(1000 + intArr[i][0] * 100);
            } else if(intArr[i][1] == intArr[i][2]) {
                prices.add(1000 + intArr[i][1] * 100);
            } else if(intArr[i][0] == intArr[i][2]) {
                prices.add(1000 + intArr[i][0] * 100);
            } else {
                int max = 0;
                if(max < intArr[i][0]) {
                    max = intArr[i][0];
                }
                if(max < intArr[i][1]) {
                    max = intArr[i][1];
                }
                if(max < intArr[i][2]) {
                    max = intArr[i][2];
                }
                prices.add(max * 100);
            }
        }
        Collections.sort(prices);
        Collections.swap(prices, 0, prices.size()-1);
        System.out.println(prices.get(0));
    }
}
