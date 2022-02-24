package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortingExample1 {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        boolean swap = false;
        for(int i=0; i<dataList.size()-1; i++) {
            int minValue = dataList.get(i);
            for(int j=i; j<dataList.size()-1; j++) {
                if(minValue > dataList.get(j + 1)) {
                    int pivot = minValue;
                    minValue = dataList.get(j + 1);
                    dataList.set(j + 1, pivot);
                    swap = true;
                }
            }
            dataList.set(i, minValue);
            if(swap == false) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        SelectionSortingExample1 sSort = new SelectionSortingExample1();
        sSort.sort(testData);
        System.out.println(testData);
    }
}
