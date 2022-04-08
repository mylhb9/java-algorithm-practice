package level8;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 모든 부등호 관계를 만족시키려고 한다.
// 부등호 기호 앞뒤에 넣을 수 있는 숫자는 0~9 까지의 정수이며 선택된 숫자는 모두 달라야한다.
// 부등호 관계를 만족시키는 최대정수와 최소정수를 출력하라
public class InEqual1 {
    int n, m;
    Integer[] arrMax;
    Integer[] arrMin;
    boolean[] visitedMin;
    boolean[] visitedMax;
    String[] signs;
    boolean checkMin = false;
    boolean checkMax = false;

    public void recurMin(int x) {
        if(x == n) {
            if(!checkMin) {
                for(int i=0; i<n; i++) {
                    System.out.print(arrMin[i]);
                }
                System.out.println();
                checkMin = true;
            }
        } else {
            for(int i=0; i<m; i++) {
                if(x==0) {
                    arrMin[x] = i;
                    visitedMin[i] = true;
                    recurMin(x+1);
                    visitedMin[i] = false;
                } else {
                    if(!visitedMin[i] && judge(arrMin[x-1], i, signs[x-1])) {
                        arrMin[x] = i;
                        visitedMin[i] = true;
                        recurMin(x+1);
                        visitedMin[i] = false;
                    }

                }
            }
        }
    }

    public void recurMax(int x) {
        if(x == n) {
            if(!checkMax) {
                for(int i=0; i<n; i++) {
                    System.out.print(arrMax[i]);
                }
                System.out.println();
                checkMax = true;
            }
        } else {
            for(int i=m-1; i>=0; i--) {
                if(x==0) {
                    arrMax[x] = i;
                    visitedMax[i] = true;
                    recurMax(x+1);
                    visitedMax[i] = false;
                } else {
                    if(!visitedMax[i] && judge(arrMax[x-1], i, signs[x-1])) {
                        arrMax[x] = i;
                        visitedMax[i] = true;
                        recurMax(x+1);
                        visitedMax[i] = false;
                    }

                }
            }
        }
    }

    public boolean judge(int x, int y, String sign) {
        if(sign.equals(">")) {
            if(x>y) {
                return true;
            } else {
                return false;
            }
        } else {
            if(x<y) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
// 입력: 첫 줄에 부등호 문자의 개수를 나타내는 정수가 주어짐. 그 다음 줄에는 k 개의 부등호 기호가 하나의 공백을 두고 한줄에 모두 제시
// k의 범위는 2<=k<=9
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String[] strArr = sc.nextLine().split(" ");

        InEqual1 main = new InEqual1();
        main.n = k + 1;
        main.m = 10;
        main.signs = strArr;
        main.visitedMin = new boolean[11];
        main.visitedMax = new boolean[11];
        Arrays.fill(main.visitedMin, false);
        Arrays.fill(main.visitedMax, false);
        main.arrMax = new Integer[11];
        main.arrMin = new Integer[11];
        main.recurMax(0);
        main.recurMin(0);

    }
}
