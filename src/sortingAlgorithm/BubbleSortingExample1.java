package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSortingExample1 {
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();

        dataList.add(4);
        dataList.add(2);

        if(dataList.get(0) > dataList.get(1)) {
            Collections.swap(dataList, 0, 1);
        }

        System.out.println(dataList);
    }

}
