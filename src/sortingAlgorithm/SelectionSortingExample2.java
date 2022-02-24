package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortingExample2 {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for(int stand=0; stand<dataList.size(); stand++) {
            int lowest = stand;
            for(int index = stand + 1; index<dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
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
