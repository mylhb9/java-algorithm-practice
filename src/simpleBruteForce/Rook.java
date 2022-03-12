package simpleBruteForce;

import java.util.*;

public class Rook {
    public static void main(String[] args) {
        // 외부로부터 체스판을 입력받음
        Scanner sc = new Scanner(System.in);

        String[][] strArr = new String[8][8];
        for(int i=0; i<8; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        Integer[][] intArr = new Integer[8][8];
        List<Integer> rookX = new ArrayList<>();
        List<Integer> rookY = new ArrayList<>();
        int rookNum = 0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                intArr[i][j] = Integer.parseInt(strArr[i][j]);
                if(intArr[i][j] == 2) {
                    rookX.add(i);
                    rookY.add(j);
                    rookNum++;
                }
            }
        }

        // rook 을 기준으로 상하좌우를 체크하고 1이 있다면 1을 출력
        // 도중에 2, 3을 만난다면 break
        // rook 의 개수 만큼 체크를 해줘야한다.
        for(int i=0; i<rookNum; i++) {
            for(int j=rookY.get(i); j<8; j++) {
                if(intArr[rookX.get(i)][j] == 3) {
                    break;
                } else if(intArr[rookX.get(i)][j] == 1) {
                    System.out.println(1);
                    return;
                } else {
                    continue;
                }
            }
            for(int j=rookY.get(i)-1; j>=0; j--) {
                if(intArr[rookX.get(i)][j] == 3) {
                    break;
                } else if(intArr[rookX.get(i)][j] == 1) {
                    System.out.println(1);
                    return;
                } else {
                    continue;
                }
            }
            for(int j=rookX.get(i); j<8; j++) {
                if(intArr[j][rookY.get(i)] == 3) {
                    break;
                } else if(intArr[j][rookY.get(i)] == 1) {
                    System.out.println(1);
                    return;
                } else {
                    continue;
                }
            }
            for(int j=rookX.get(i)-1; j>=0; j--) {
                if(intArr[j][rookY.get(i)] == 3) {
                    break;
                } else if(intArr[j][rookY.get(i)] == 1) {
                    System.out.println(1);
                    return;
                } else {
                    continue;
                }
            }
        }
        System.out.println(0);





    }
}
