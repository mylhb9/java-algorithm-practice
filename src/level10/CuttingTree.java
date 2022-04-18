package level10;


// 문제: H를 설정해서 적어도 M 미터의 나무를 가져가기, 이때 H 값을 구해라
import java.util.Scanner;


// 입력: 첫쨰 줄에 나무의 수 N과 윤성이가 집으로 가져가려는 나무의 길이 M이 주어진다
// 둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M을 넘어서, 윤성이는 항상 집에 필요한 나무를 가져갈 수 있다

// 출력: 적어도 M 미터의 나무를 집에 가져가기 위해여 절단기에 설정할 수 있는 높이의 최대값을 출력한다.
public class CuttingTree {
    long[] arr;
    long M;
    public boolean check(long H) {
        long sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]-H >=0) {
                sum += (arr[i]-H);
            }

        }
//        System.out.println(sum);
        if(sum >= M) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();
        long[] arr = new long[(int)N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        CuttingTree m = new CuttingTree();
        m.M = M;
        m.arr = arr;

        long start = 0;
        long end = 3000000000L;

        while(start+1 < end) {
            long mid = (start+end) / 2;
            if(m.check(mid)) {
               start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}
