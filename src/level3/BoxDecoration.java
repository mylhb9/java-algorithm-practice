package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BoxDecoration {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if(n < 6) {
            System.out.println("NO");
            return;
        }
        String[] strArr = sc.nextLine().split(" ");
        Integer[] intArr = new Integer[n];
        for(int i=0; i<n; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr);
        int count = 0;
        List<Integer> countList = new ArrayList<>();
        int idx = 0;
        List<Integer> idxList = new ArrayList<>();
        for(int i=1; i<n; i++) {
            idx++;
            if(intArr[i-1] != intArr[i] && i == intArr.length - 1) {
                count++;
                countList.add(count);
                idxList.add(idx);
                idx = 0;
                count++;
                countList.add(count);
                idx++;
                idxList.add(idx);
            } else if(intArr[i-1] != intArr[i]) {
                count++;
                countList.add(count);
                idxList.add(idx);
                idx = 0;
            } else if(i == intArr.length - 1) {
                count++;
                countList.add(count);
                idx++;
                idxList.add(idx);
            }
        }
        if(countList.size() == 3) {
            boolean check = false;
            for(int i=0; i<idxList.size(); i++) {
                if(idxList.get(i) < 2) {
                    check = true;
                    System.out.println("NO");
                    break;
                }
            }
            if(!check) {
                System.out.println("YES");
            }
        } else if(countList.size() == 4) {
            boolean check = false;
            for(int i=0; i<idxList.size(); i++) {
                if(idxList.get(i) == 2) {
                    check = true;
                    System.out.println("YES");
                    break;
                }
            }
            if(!check) {
                System.out.println("NO");
            }
        } else if(countList.size() >= 5) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.out.println(countList);
        System.out.println(idxList);
    }
}