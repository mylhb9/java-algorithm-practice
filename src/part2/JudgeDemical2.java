package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JudgeDemical2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        List<Integer> demicalList = new ArrayList<>();
        for(int i=n; i<=m; i++) {
            if(i==1) {
                continue;
            }
            boolean check = false;
            for(int j=2; j<i; j++) {
                if(i % j == 0) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                demicalList.add(i);
            }
        }
        for(int i=0; i<demicalList.size(); i++) {
            System.out.print(demicalList.get(i) + " ");
        }
    }
}
