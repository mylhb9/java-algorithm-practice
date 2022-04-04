package level6;

// 문제: 두 자연수가 주어질 때, 그들의 덧셈을 계산하는 프로그램을 작성
// 각 수는 1 이상 10^100 미만의 범위를 가짐

// 입력: 두 자연수가 주어짐
// 출력: 덧셈의 결과를 출력한다.

import java.util.Scanner;

public class AddLargeDigits1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: 두 자연수를 받음
        String[] firstInputNum = sc.nextLine().split("");
        String[] secondInputNum = sc.nextLine().split("");
        int numSize = 0;
        int digitDiff = 0;
        if(firstInputNum.length > secondInputNum.length) {
            numSize = firstInputNum.length + 1;
            digitDiff = firstInputNum.length - secondInputNum.length + 1;
        } else {
            numSize = secondInputNum.length + 1;
            digitDiff = secondInputNum.length - firstInputNum.length + 1;
        }
        // 입력된 자연수를 계산하기 위해 배열에 나누어 담기
        Integer[] firstNum = new Integer[numSize];
        Integer[] secondNum = new Integer[numSize];

        // 숫자 입력 받기
        if(firstInputNum.length > secondInputNum.length) {
            for(int i=0; i<numSize; i++) {
                if(i == 0) {
                    firstNum[i] = 0;
                } else {
                    firstNum[i] = Integer.parseInt(firstInputNum[i-1]);
                }
                if(i < digitDiff) {
                    secondNum[i] = 0;
                } else {
                    secondNum[i] = Integer.parseInt(secondInputNum[i-digitDiff]);
                }
            }
        } else {
            for(int i=0; i<numSize; i++) {
                if(i == 0) {
                    secondNum[i] = 0;
                } else {
                    secondNum[i] = Integer.parseInt(secondInputNum[i-1]);
                }
                if(i < digitDiff) {
                    firstNum[i] = 0;
                } else {
                    firstNum[i] = Integer.parseInt(firstInputNum[i-digitDiff]);
                }
            }
        }

        Integer[] sumNum = new Integer[numSize];
        for(int i=0; i< sumNum.length; i++) {
            sumNum[i] = 0;
        }
        // 자리 수 별로 숫자를 덧셈하기
        for(int i=numSize-1; i>=0; i--) {
            sumNum[i] += firstNum[i] + secondNum[i];
            if(sumNum[i] > 9) {
                sumNum[i] -= 10;
                sumNum[i-1] += 1;
            }
        }

        if(sumNum[0] != 0) {
            for(int i=0; i< sumNum.length; i++) {
                System.out.print(sumNum[i]);
            }
        } else {
            for(int i=1; i< sumNum.length; i++) {
                System.out.print(sumNum[i]);
            }
        }

    }
}
