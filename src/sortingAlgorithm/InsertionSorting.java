package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InsertionSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArr= sc.nextLine().split(" ");

        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            intList.add(Integer.parseInt(strArr[i]));
        }

        for(int i=0; i<N; i++) {
            for(int j=i; j>0; j--) {
                if(intList.get(j) < intList.get(j-1)) {
                    Collections.swap(intList, j, j-1);
                } else {
                    break;
                }
            }
        }


        System.out.print(intList);

    }
}
