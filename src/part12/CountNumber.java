package part12;

import java.util.Arrays;
import java.util.Scanner;

// 문제: n개의 숫자가 주어지고 q개의 질문이 주어진다. 각각의 질문은 n개의 숫자 중 특정 숫자가 몇개나 있는지를 물음
// 입력: 첫 번째 줄에 숫자의 개수 n, 질문의 개수 q가 주어짐
// 두 번째 줄에 n개의 숫자가 주어진다. 세 번째 줄에 q개의 질문이 주어진다.
public class CountNumber {
    int n;
    int[] numArr;
    public int binarySearchLeft(int value) {
        int s1 = 0;
        int e1 = n-1;

        while(s1+1 < e1) {
            int mid = (s1+e1) / 2;
            if(numArr[mid] < value) {
                s1 = mid;
            } else {
                e1 = mid;
            }
        }
        return e1;
    }

    public int binarySearchRight(int value) {
        int s1 = 0;
        int e1 = n-1;

        while(s1+1 < e1) {
            int mid = (s1+e1) / 2;
            if(numArr[mid] <= value) {
                s1 = mid;
            } else {
                e1 = mid;
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] numArr = new int[n];
        for(int i=0; i<n; i++) {
            numArr[i] = sc.nextInt();
        }

        int[] questionArr = new int[q];
        for(int i=0; i<q; i++) {
            questionArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);
        // 1 1 2 2 3 3 3 4 5 10
        // 1 2 3 4 5 6 7 8 9 10

        CountNumber m = new CountNumber();
        m.n = n;
        m.numArr = numArr;


        for(int i=0; i<questionArr.length; i++) {
            if(questionArr[i] == numArr[0]) {
                System.out.println(m.binarySearchRight(questionArr[i]) - m.binarySearchLeft(questionArr[i]) + 2);
                continue;
            }
            if(questionArr[i] == numArr[n-1]) {
                System.out.println(m.binarySearchRight(questionArr[i]) - m.binarySearchLeft(questionArr[i]) + 2);
                continue;
            }
            System.out.println(m.binarySearchRight(questionArr[i]) - m.binarySearchLeft(questionArr[i]) + 1);
        }

    }
}
