package level5;

import java.util.Scanner;

public class FindPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        // 입력 받은 수를 배열에 넣기
        Integer[] intArr = new Integer[N];
        for(int i=0; i<N; i++) {
            intArr[i] = Integer.parseInt(sc.nextLine());
        }

        // 배열을 2 이상의 수로 나누었을 때, 자기 자신만 나누어지는 수를 체크
        int count = 0;
        for(int i=0; i<N; i++) {
            boolean check = false;
            if(intArr[i] == 1) {
                check = true;
            }
            for(int j=2; j<intArr[i]; j++) {
                if(intArr[i] % j == 0) {
                    check = true;
                }
            }
            if(!check) {
                count++;
            }
        }
        System.out.println(count);
    }
}
