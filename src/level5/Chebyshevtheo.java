package level5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 문제: 베르트랑-체비쇼프 정리
// n이 주어졌을 때, n 보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성
// 입력: 여러 개의 테스트 케이스로 이루어짐. 각 케이스는 n을 포함하며 한 줄로 이러우져 있음 (n<= 123456)
// 입력의 마지막에는 0 이 주어진다.
// 출력 각 테스트 케이스에 대해서, n보다 크고 2n 보다 작거나 같은 소수의 개수를 출력한다.
public class Chebyshevtheo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<Integer> integerList = new ArrayList<>();
        while(true) {
            int a = Integer.parseInt(sc.nextLine());
            if(a == 0) {
                break;
            }
            integerList.add(a);
        }

        for(int i=0; i<integerList.size(); i++) {
            int count = 0;
            for(int j=integerList.get(i)+1; j<=2*integerList.get(i); j++) {
                boolean check = false;
                for(int k=2; k<j; k++) {
                    if(j % k == 0) {
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
}
