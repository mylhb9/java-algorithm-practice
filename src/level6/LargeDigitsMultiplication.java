package level6;


// 문제: 두 자연수가 주어질 때, 곱셈을 계산하는 프로그램을 작성
// 각 수는 1 이상 10^100 미만의 범위를 가진다.


// 곱셈에 의한 자리수 증가는 맨처음 수의 자리수에 그다음 수의 자리수 -1 을 더하면 된다.
import java.util.Arrays;
import java.util.Scanner;

public class LargeDigitsMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstInputNum = sc.nextLine().split("");
        String[] secondInputNum = sc.nextLine().split("");

        int numSize = firstInputNum.length + secondInputNum.length - 1;

        // 입력 값 받기
        Integer[] firstNum = new Integer[firstInputNum.length];
        for(int i=0; i<firstNum.length; i++) {
            firstNum[i] = Integer.parseInt(firstInputNum[i]);
        }
        Integer[] secondNum = new Integer[secondInputNum.length];
        for(int i=0; i<secondInputNum.length; i++) {
            secondNum[i] = Integer.parseInt(secondInputNum[i]);
        }

        // 계산용 배열 초기화
        Integer[][] matrix = new Integer[secondNum.length][numSize];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }

        // 계산용 배열 작성


        for(int i=secondNum.length-1; i>=0; i--) {
            for(int j=numSize-1; j>=0; j--) {
                if(j< firstNum.length) {
                    matrix[i][j-i+secondNum.length-1] = firstNum[j] * secondNum[(secondNum.length-1)-i];
                }

            }
        }

        Integer[] answer = new Integer[numSize+1];
        Arrays.fill(answer, 0);
        for(int i=numSize-1; i>=0; i--) {
            for(int j=0; j<secondNum.length; j++) {
                answer[i+1] += matrix[j][i];
            }
            int a = answer[i+1] / 10;
            int b = answer[i+1] % 10;

            answer[i] += a;

            answer[i+1] = b;

        }

        if(answer[0] == 0) {
            for(int i=1; i< answer.length; i++) {
                System.out.print(answer[i]);
            }
        } else {
            for(int i=0; i< answer.length; i++) {
                System.out.print(answer[i]);
            }
        }
    }
}
