package level5;

import java.util.Scanner;

public class NextNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // 테스트 케이스의 개수가 주어지지 않은 상태에서 입력 받기
        int i =0;
        String[][] strArr = new String[1000][3];
        while(true) {
            strArr[i] = sc.nextLine().split(" ");
            if(strArr[i][0].equals("0") && strArr[i][1].equals("0") && strArr[i][2].equals("0")) {
                break;
            }
            i++;
        }


        Integer[][] inputArr = new Integer[i][3];
        for(int j=0; j<i; j++) {
            for(int k=0; k<3; k++) {
                inputArr[j][k] = Integer.parseInt(strArr[j][k]);
            }
        }

        // 출력하기
        for(int j=0; j<i; j++) {
            if((inputArr[j][1] - inputArr[j][0]) == (inputArr[j][2] - inputArr[j][1])) {
                System.out.println("AP " +  (inputArr[j][2] + inputArr[j][1] - inputArr[j][0]));
            } else {
                System.out.println("GP " +  (inputArr[j][2] * (inputArr[j][1] / inputArr[j][0])));
            }
        }
    }
}
