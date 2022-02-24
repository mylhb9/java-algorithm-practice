package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSortingExample1 {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for(int i=0; i<dataList.size(); i++) {
            int lowest = i;
            for(int j=i; j>=0; j--) {
                if(dataList.get(j) > dataList.get(lowest)) {
                    Collections.swap(dataList, j, lowest);
                    lowest = j;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        InsertionSortingExample1 iSort = new InsertionSortingExample1();
        iSort.sort(testData);
        System.out.println(testData);
    }
}
