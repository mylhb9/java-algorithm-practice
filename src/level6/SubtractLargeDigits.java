package level6;

// 문제: 두 자연수가 주어질 때, 그들의 뺄셈을 계산하는 프로그램을 작성해라
// 각 수는 1이상 10^100 미만의 범위를 가진다

import java.util.Arrays;
import java.util.Scanner;

public class SubtractLargeDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstInputNum = sc.nextLine().split("");
        String[] secondInputNum = sc.nextLine().split("");

        int numSize = 0;
        int digitsDiff = 0;
        if(firstInputNum.length > secondInputNum.length) {
            numSize = firstInputNum.length;
            digitsDiff = firstInputNum.length - secondInputNum.length ;
        } else {
            numSize = secondInputNum.length;
            digitsDiff = secondInputNum.length - firstInputNum.length;
        }

        Integer[] firstNum = new Integer[numSize];
        Integer[] secondNum = new Integer[numSize];

        if(firstInputNum.length > secondInputNum.length) {
            for(int i=0; i<numSize; i++) {
                firstNum[i] = Integer.parseInt(firstInputNum[i]);
                if(i<digitsDiff) {
                    secondNum[i] = 0;
                } else {
                    secondNum[i] = Integer.parseInt(secondInputNum[i-digitsDiff]);
                }
            }
        } else {
            for(int i=0; i<numSize; i++) {
                secondNum[i] = Integer.parseInt(secondInputNum[i]);
                if(i<digitsDiff) {
                    firstNum[i] = 0;
                } else {
                    firstNum[i] = Integer.parseInt(firstInputNum[i-digitsDiff]);
                }
            }
        }

        Integer[] minusNum = new Integer[numSize];
        Arrays.fill(minusNum, 0);
        if(firstInputNum.length > secondInputNum.length) {
            for(int i=numSize-1; i>=0; i--) {
                minusNum[i] += firstNum[i] - secondNum[i];
                if(minusNum[i] < 0) {
                    minusNum[i] += 10;
                    minusNum[i-1] -= 1;
                }
            }
            boolean chek = false;
            for(int i=0; i<minusNum.length; i++) {
                if(minusNum[i] != 0) {
                    chek = true;
                }
                if(!(minusNum[i] == 0 && !chek)) {
                    System.out.print(minusNum[i]);
                }
            }
        } else if(firstInputNum.length == secondInputNum.length){
            boolean check = false;
            boolean equal = false;
            for(int k=0; k<numSize; k++) {
                if(firstNum[k] > secondNum[k]) {
                    check = true;
                    equal = true;
                    break;
                } else if(firstNum[k] == secondNum[k]) {

                    continue;
                } else {
                    check = false;
                    equal= true;
                    break;
                }

            }
            if(check) {
                for(int i=numSize-1; i>=0; i--) {
                    minusNum[i] += firstNum[i] - secondNum[i];
                    if(minusNum[i] < 0) {
                        minusNum[i] += 10;
                        minusNum[i-1] -= 1;
                    }
                }
                boolean chek = false;
                for(int i=0; i<minusNum.length; i++) {
                    if(minusNum[i] != 0) {
                        chek = true;
                    }
                    if(!(minusNum[i] == 0 && !chek)) {
                        System.out.print(minusNum[i]);
                    }
                }
            } else if(!equal) {
                System.out.println(0);

            } else {
                for(int i=numSize-1; i>=0; i--) {
                    minusNum[i] += secondNum[i] - firstNum[i];
                    if(minusNum[i] < 0) {
                        minusNum[i] += 10;
                        minusNum[i-1] -= 1;
                    }
                }
                System.out.print("-");
                boolean chek = false;
                for(int i=0; i<minusNum.length; i++) {
                    if(minusNum[i] != 0) {
                        chek = true;
                    }
                    if(!(minusNum[i] == 0 && !chek)) {
                        System.out.print(minusNum[i]);
                    }
                }
            }

        } else {
            for(int i=numSize-1; i>=0; i--) {
                minusNum[i] += secondNum[i] - firstNum[i];
                if(minusNum[i] < 0) {
                    minusNum[i] += 10;
                    minusNum[i-1] -= 1;
                }
            }
            System.out.print("-");
            boolean chek = false;
            for(int i=0; i<minusNum.length; i++) {
                if(minusNum[i] != 0) {
                    chek = true;
                }
                if(!(minusNum[i] == 0 && !chek)) {
                    System.out.print(minusNum[i]);
                }
            }


        }


    }
}
