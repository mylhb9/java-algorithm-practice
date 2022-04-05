package level8;

import java.util.Scanner;

// 문제: 두 종류의 부등호 기호 < > 가 k 개 나열된 순서열 A가 있다.
// 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키고자 한다.
// 0 부터 9까지 정수 중에 넣을 수 있으며, 선택된 숫자는 모두 달라야한다.
// 주어진 부등화 관계를 만족시키는 정수는 하나 이상 존재한다.
// 제시된 k 개의 부등호 순서를 만족시키는 k+1 자리의 정수중에서 최댓값과 최솟값을 찾아야한다,
// 각 부등호의 앞뒤에 들어간느 숫자는 0~9 사이에 선택해야하며, 선택된 숫자는 모두 달라야한다.
// 실행시간은 0.5초를 넘을 수 없다.
public class Main {
    int k;
    public void inEqual(int x) {
        if(x >= k+1) {
            System.out.println();
        } else {
            for(int i=k; i>=0; i--) {

            }
        }
    }

    public boolean judge(int a, int b, String str) {
        if(str.equals(">")) {
            if(a>b) {
                return true;
            } else {
                return false;
            }
        } else {
            if(a>b) {
                return false;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());
        String[] inputArr = sc.nextLine().split(" ");


    }
}
