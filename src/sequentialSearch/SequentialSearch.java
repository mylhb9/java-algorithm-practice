package sequentialSearch;

import java.util.ArrayList;

public class SequentialSearch {
    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for(int i=0; i<dataList.size(); i++) {
            if(dataList.get(i) == searchItem) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for(int i=0; i<10; i++) {
            testData.add((int)(Math.random() * 100));
        }


        SequentialSearch ss = new SequentialSearch();
        System.out.println(ss.searchFunc(testData, 99));
    }
}
