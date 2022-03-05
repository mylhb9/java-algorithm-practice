package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if(dataList.size() == 1 && dataList.get(0) == searchItem) {
            return true;
        }
        if(dataList.size() == 1 && dataList.get(0) != searchItem) {
            return false;
        }
        if(dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;
        if(dataList.get(medium) > searchItem) {
            return this.searchFunc(new ArrayList<>(dataList.subList(0, medium)), searchItem);
        } else {
            return this.searchFunc(new ArrayList<>(dataList.subList(medium, dataList.size())), searchItem);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for(int i=0; i<100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        Collections.sort(testData);
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.searchFunc(testData, 2));
    }
}
