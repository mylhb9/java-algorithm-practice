package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest = 0;
        for(int i=0; i<dataList.size(); i++) {
            lowest = i;
            for(int j=i+1; j<dataList.size(); j++) {
                if(dataList.get(j) < dataList.get(lowest)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, i, lowest);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        SelectionSort sSort = new SelectionSort();
        System.out.println(sSort.sort(testData));
    }
}
