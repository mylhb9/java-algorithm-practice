package level8;

import java.util.Arrays;
import java.util.Scanner;

// 문제: 두 종류의 부등호 기호 < > 가 k 개 나열된 순서열 A가 있다.
// 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키고자 한다.
// 0 부터 9까지 정수 중에 넣을 수 있으며, 선택된 숫자는 모두 달라야한다.
// 주어진 부등화 관계를 만족시키는 정수는 하나 이상 존재한다.
// 제시된 k 개의 부등호 순서를 만족시키는 k+1 자리의 정수중에서 최댓값과 최솟값을 찾아야한다,
// 각 부등호의 앞뒤에 들어간느 숫자는 0~9 사이에 선택해야하며, 선택된 숫자는 모두 달라야한다.
// 실행시간은 0.5초를 넘을 수 없다.
public class InEqual {
    int k;
    Integer[] notesMax;
    Integer[] notesMin;
    String[] signs;
    boolean[] checkMax;
    boolean[] checkMin;
    boolean printMin = false;
    boolean printMax = false;

    public boolean judge(int x, int y, String sign) {
        if(sign.equals(">")) {
            if(x > y) {
                return true;
            } else {
                return false;
            }
        } else {
            if(x < y) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void getMax(int x) {
        if(x >= k+1) {
            if(!printMax) {
                for(int i=0; i< k+1; i++) {
                    if(notesMax[i] !=null) {
                        System.out.print(notesMax[i]);
                    }
                }
                System.out.println();
                printMax = true;
            }
        } else {
            for(int i=9; i>=0; i--) {
                if(x==0) {
                    notesMax[x] = i;
                    checkMax[i] = true;
                    getMax(x+1);
                    checkMax[i] = false;
                    notesMax[x] = 0;
                } else {
                    if(!checkMax[i] && judge(notesMax[x-1], i, signs[x-1])) {
                        notesMax[x] = i;
                        checkMax[i] = true;
                        getMax(x+1);
                        checkMax[i] = false;
                        notesMax[x] = 0;
                    }
                }
            }
        }
    }


    public void getMin(int x) {
        if(x >= k+1) {
            if(!printMin) {
                for(int i=0; i< k+1; i++) {
                    if(notesMin[i] !=null) {
                        System.out.print(notesMin[i]);
                    }
                }
                System.out.println();
                printMin = true;
            }
        } else {
            for(int i=0; i<=9; i++) {
                if(x==0) {
                    notesMin[x] = i;
                    checkMin[i] = true;
                    getMin(x+1);
                    checkMin[i] = false;
                    notesMin[x] = 0;
                } else {
                    if(!checkMin[i] && judge(notesMin[x-1], i, signs[x-1])) {
                        notesMin[x] = i;
                        checkMin[i] = true;
                        getMin(x+1);
                        checkMin[i] = false;
                        notesMin[x] = 0;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());

        String[] strArr = sc.nextLine().split(" ");
        InEqual m = new InEqual();
        m.k = k;
        m.notesMax = new Integer[15];
        m.notesMin = new Integer[15];
        m.signs = strArr;
        m.checkMax = new boolean[15];
        m.checkMin = new boolean[15];
        Arrays.fill(m.checkMax, false);
        Arrays.fill(m.checkMin, false);
        m.getMax(0);
        m.getMin(0);

    }
}
