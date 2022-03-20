package level3;

import java.util.*;

public class RepresentativeValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] intArr = new Integer[10];
        for(int i=0; i<10; i++) {
            intArr[i] = Integer.parseInt(sc.nextLine());
        }

        int sum = 0;
        for(int i=0; i<10; i++) {
            sum += intArr[i];
        }
        System.out.println(sum / 10);

        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        int count = 1;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i=1; i<10; i++) {
            if(intArr[i-1] != intArr[i] && i==9) {
                myMap.put(intArr[i-1], count);
                count = 1;
                myMap.put(intArr[i], count);
            } else if(intArr[i-1] != intArr[i]) {
                myMap.put(intArr[i-1], count);
                count = 1;
            } else if(i == 9) {
                count++;
                myMap.put(intArr[i], count);
            } else {
                count++;
            }

        }
        System.out.println(myMap);
        int max = 0;
        int index = 0;
        for(Integer idx : myMap.keySet()) {
            max = Math.max(max, myMap.get(idx));
        }
        List<Integer> equalList = new ArrayList<>();
        for(Integer idx : myMap.keySet()) {
            if(myMap.get(idx) == max) {
                equalList.add(idx);
            }
        }
        int mn = Integer.MAX_VALUE;
        for(int i=0; i<equalList.size(); i++) {
            mn = Math.min(mn, equalList.get(i));
        }

        System.out.println(mn);
    }
}
