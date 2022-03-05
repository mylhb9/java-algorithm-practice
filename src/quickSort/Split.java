package quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Split {
    public void splitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return;
        } else {
            int pivot = dataList.get(0);
            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            // pivot 과 겹치지 않기 위해서 1부터 넣어줘야한다.
            for(int i=1; i<dataList.size(); i++) {
                if(dataList.get(i) > pivot) {
                    rightArr.add(dataList.get(i));
                } else {
                    leftArr.add(dataList.get(i));
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


    }

    public static void main(String[] args) {
        Split sp = new Split();
        Integer[] dataList = {4, 1, 2, 5, 7};
        sp.splitFunc(new ArrayList<>(Arrays.asList(dataList)));

    }
}
