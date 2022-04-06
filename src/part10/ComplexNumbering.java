package part10;

import java.util.*;

// 문제: 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
// 연결된 집들의 모임인 단지를 만든다
// 좌우 혹은 아래위로 다른 집이 있는 경우를 연결되었다라고 표현한다.
// 지도를 입력해서 단지수를 출력 / 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
public class ComplexNumbering {
    Integer[][] map;
    public int getGroup(int x, int y) {
        int count = 0;

        map[x][y] = 0;
        count++;

        if(map[x+1][y] == 1) {
            count += getGroup(x+1, y);
        }
        if(map[x-1][y] == 1) {
            count += getGroup(x-1, y);
        }
        if(map[x][y+1] == 1) {
            count += getGroup(x, y+1);
        }
        if(map[x][y-1] == 1) {
            count += getGroup(x, y-1);
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] inputArr = new String[N][N];
        for(int i=0; i<N; i++) {
            inputArr[i] = sc.nextLine().split("");
        }

        Integer[][] map = new Integer[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<N+2; j++) {
                map[i][j] = 0;
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i+1][j+1] = Integer.parseInt(inputArr[i][j]);
            }
        }

        ComplexNumbering m = new ComplexNumbering();
        m.map = map;
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 1) {
                    result.add(m.getGroup(i, j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }





    }
}
