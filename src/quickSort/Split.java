package quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Split {
    public void splitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return;
        }

        int pivot = dataList.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int i=1; i<dataList.size(); i++) {
            if(pivot > dataList.get(i)) {
                leftArr.add(dataList.get(i));
            } else {
                rightArr.add(dataList.get(i));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(leftArr);
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(rightArr);


        System.out.println(leftArr);
        System.out.println(pivot);
        System.out.println(rightArr);
        System.out.println(mergedArr);
    }

    public static void main(String[] args) {
        Split sp = new Split();
        Integer[] dataList = {4, 1, 2, 5, 7};
        sp.splitFunc(new ArrayList<>(Arrays.asList(dataList)));

    }
}
