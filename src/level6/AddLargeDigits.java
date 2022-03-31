package level6;

import java.util.Scanner;

// 문제: 두 자연수가 주어질 때, 그들의 덧셈을 계산하는 프로그램
// 각 수는 1 이상 10^100 미만의 범위를 가진다.
// 입력: 첫 번째 줄과 두 번째 줄에 하나의 자연수가 주어진다.
// 출력: 덧셈의 결과를 출력한다.
public class AddLargeDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 처리
        // 두 수를 Integer[] 에 각각 담고, 결과를 담을 Integer[] 을 만든다.
        // for 문을 통해 각 열마다 더해가면서, 합이 9보다 크면 다음 배열에 1을 더 더해준다.

        String[] arr1 = sc.nextLine().split("");
        String[] arr2 = sc.nextLine().split("");
        String[] firstArr;
        String[] inputSecondArr;
        if(arr1.length >= arr2.length) {
            firstArr = arr1;
            inputSecondArr = arr2;
        } else {
            firstArr = arr2;
            inputSecondArr = arr1;
        }


        String[] secondArr = new String[firstArr.length];
        for(int i=0; i<inputSecondArr.length; i++) {
            secondArr[i+(firstArr.length - inputSecondArr.length)] = inputSecondArr[i];
        }

        Integer[] intFirstArr = new Integer[firstArr.length];
        Integer[] intSecondArr = new Integer[firstArr.length];
        Integer[] sumArr = new Integer[firstArr.length+1];

        for(int i=0; i<intFirstArr.length; i++) {
            if(firstArr[firstArr.length-1-i] == null) {
                intFirstArr[i] = 0;
            } else {
                intFirstArr[i] = Integer.parseInt(firstArr[firstArr.length-1-i]);
            }

        }
        for(int i=0; i<intSecondArr.length; i++) {
            if(secondArr[secondArr.length-1-i] == null) {
                intSecondArr[i] = 0;
            } else {
                intSecondArr[i] = Integer.parseInt(secondArr[secondArr.length-1-i]);
            }

        }

        for(int i=0; i<sumArr.length; i++) {
            sumArr[i] = 0;
        }


        for(int i=0; i<intFirstArr.length; i++) {
            int a = intFirstArr[i] + intSecondArr[i];
            if(a>9) {
                sumArr[i] += a - 10;
                sumArr[i+1] += 1;
            } else {
                sumArr[i] += a;
            }
        }
        if(sumArr[sumArr.length-1] != 0) {
            for(int i=0; i<sumArr.length; i++) {
                System.out.print(sumArr[sumArr.length-1-i]);
            }
        } else {
            for(int i=1; i<sumArr.length; i++) {
                System.out.print(sumArr[sumArr.length-1-i]);
            }
        }

    }
}
