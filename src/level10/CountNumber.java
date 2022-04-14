package level10;

// 문제: n개의 숫자가 주어지고, q개의 질문이 주어진다.
// n개의 숫자 중에서 특정숫자가 몇개나 있는지 묻는다

// 입력: 숫자의 개수 n(1 <= n <= 100,000), 질문의 개수 q (1 <= q <= 100,000)가 주어진다.
// 두 번째 줄에 n개의 숫자가 주어진다.
// 세 번째 줄에 q개의 질문이 주어진다.

// 출력: 숫자의 개수를 한 줄에 하나씩 출력

import java.util.*;

public class CountNumber {
    Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int q = Integer.parseInt(strArr[1]);

        CountNumber m = new CountNumber();

        String[] questionArr = sc.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            m.map.put(Integer.parseInt(questionArr[i]), 0);
        }

        for(int i=0; i<n; i++) {
            m.map.put(Integer.parseInt(questionArr[i]), m.map.get(Integer.parseInt(questionArr[i]))+1);
        }

        String[] answerArr = sc.nextLine().split(" ");
        for(int i=0; i<q; i++) {
            if(m.map.get(Integer.parseInt(answerArr[i])) == null) {
                System.out.println(0);
            } else {
                System.out.println(m.map.get(Integer.parseInt(answerArr[i])));
            }

        }


    }
}
