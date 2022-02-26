package mergeSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortExample1 {
    public void splitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return;
        }

        int num = dataList.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<>(dataList.subList(0, num));
        ArrayList<Integer> rightList = new ArrayList<>(dataList.subList(num, dataList.size()));

        System.out.println(leftList);
        System.out.println(rightList);
    }

    public static void main(String[] args) {
        MergeSortExample1 mse = new MergeSortExample1();
        System.out.println(mse.mergedSplitFunc(new ArrayList<>(Arrays.asList(4, 3, 2, 1))));
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // Case1: left/right 둘다 있을 때
        while((leftPoint < leftList.size()) && (rightPoint < rightList.size())) {
            if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // Case2: left 만 있을 때
        while(leftPoint < leftList.size()) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // Case3: right 만 있을 때
        while(rightPoint < rightList.size()) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergedSplitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int num = dataList.size() / 2;
        ArrayList<Integer> leftList = this.mergedSplitFunc(new ArrayList<>(dataList.subList(0, num)));
        ArrayList<Integer> rightList = this.mergedSplitFunc(new ArrayList<>(dataList.subList(num, dataList.size())));

        System.out.println("leftList: " + leftList);
        System.out.println("rightList: " + rightList);
        return this.mergeFunc(leftList, rightList);
    }
}
