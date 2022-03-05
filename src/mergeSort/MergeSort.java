package mergeSort;

import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        } else {
            int medium = dataList.size() / 2;
            ArrayList<Integer> leftList = mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
            ArrayList<Integer> rightList = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

            return mergeFunc(leftList, rightList);
        }
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // Case1 : leftList, rightList 둘 다 있을때
        while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint)) ;
                leftPoint++;
            }
        }
        // Case2 : RightList 만 없을 때
        // while로 해서 위와 같이 원소 하나씩 해주는 것도 가능하다
        if(leftList.size() > leftPoint) {
            Collections.sort(leftList);
            mergedList.addAll(leftList);
        }

        // Case3 : LeftList 만 없을 때
        // while로 해서 위와 같이 원소 하나씩 해주는 것도 가능하다
        if(rightList.size() > rightPoint) {
            Collections.sort(rightList);
            mergedList.addAll(rightList);
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mSort = new MergeSort();
        System.out.println(mSort.mergeSplitFunc(testData));
    }
}
