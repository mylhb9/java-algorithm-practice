package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SelectionSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strArray = sc.nextLine().split(" ");


        List<Integer> intArray = new ArrayList<>();
        for(int i=0; i<N; i++) {
            intArray.add(Integer.parseInt(strArray[i]));
        }

        for(int i=0; i<intArray.size(); i++) {
            int idx = i;
            for(int j=i+1; j<intArray.size(); j++) {
                if(intArray.get(idx) > intArray.get(j)) {
                    idx = j;

                }
            }
            Collections.swap(intArray, i, idx);

        }
        System.out.println(intArray);

    }
}
