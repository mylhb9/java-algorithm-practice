package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSortingExample2 {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        boolean swap = false;
        for(int i=0; i<dataList.size()-1; i++) {

            for(int j=0; j<dataList.size()-1 - i; j++) {
                if(dataList.get(j) > dataList.get(j+1)) {
                    Collections.swap(dataList, j, j+1);
                    swap = true;
                }
            }

            if(swap == false) {
                break;
            }

        }
        return dataList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> testData = new ArrayList<>();
        for(int i=0; i<100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        BubbleSortingExample2 bSort = new BubbleSortingExample2();
        bSort.sort(testData);
        System.out.println(testData);
    }
}
