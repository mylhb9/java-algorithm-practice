package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BubbleSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArray = sc.nextLine().split(" ");

        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            intList.add(Integer.parseInt(strArray[i]));
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-i-1; j++) {
                if(intList.get(j) > intList.get(j+1)) {
                    Collections.swap(intList, j, j+1);
                }
            }
        }

        System.out.println(intList);

    }
}
