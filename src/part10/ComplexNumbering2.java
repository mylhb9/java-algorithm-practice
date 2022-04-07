package part10;


// 문제: 정사각형 모양의 지도가 있다. 1은 집이 있는 곳, 0은 집이 없는 곳이다.
// 지도를 입력하여 단지 수를 출력하고, 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성
import java.util.*;

public class ComplexNumbering2 {
    Integer[][] inputArr;
    public int printComplex(int x, int y) {
        Integer[] dx = {1, -1, 0, 0};
        Integer[] dy = {0, 0, 1, -1};
        int count = 0;

        inputArr[x][y] = 0;
        count++;

        for(int i=0; i<4; i++) {
            if(inputArr[x+dx[i]][y+dy[i]] == 1) {
                count+=printComplex(x+dx[i], y+dy[i]) ;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        // 입력: 지도의 크기 N (정사각형 5 <= N <= 25) N 줄에는 0 or 1이 입력됨
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] strArr = new String[N][N];
        for(int i=0; i<N; i++) {
            strArr[i] = sc.nextLine().split("");
        }

        Integer[][] inputArr = new Integer[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<N+2; j++) {
                if(i == 0 || j == 0 || i == N+1 || j == N+1) {
                    inputArr[i][j] = 0;
                } else {
                    inputArr[i][j] = Integer.parseInt(strArr[i-1][j-1]);
                }
            }
        }

        ComplexNumbering2 m = new ComplexNumbering2();
        m.inputArr = inputArr;
        List<Integer> countList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(m.inputArr[i][j] == 1) {
                    countList.add(m.printComplex(i, j));
                }
            }
        }
        Collections.sort(countList);


        // 출력: 총 단지수를 출력하고, 오름차순으로 정렬하여 한 줄에 하나씩 출력
        System.out.println(countList.size());
        for(int i=0; i<countList.size(); i++) {
            System.out.println(countList.get(i));
        }
    }
}
