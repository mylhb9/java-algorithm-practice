package level4;

import java.util.Scanner;

public class Seat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int R = Integer.parseInt(strArr[0]);
        int C = Integer.parseInt(strArr[1]);

        int K = Integer.parseInt(sc.nextLine());

        Integer[][] intArr = new Integer[R+2][C+2];
        for(int i=0; i<R+2; i++) {
            for(int j=0; j<C+2; j++) {
                intArr[i][j] = 0;
            }
        }


        for(int j=0; j<C+2; j++) {
            intArr[0][j] = 1;
            intArr[R+1][j] = 1;
        }
        for(int i=0; i<R+2; i++) {
            intArr[i][C+1] = 1;
            intArr[i][0] = 1;
        }

        int setPoint = Integer.min(R, C);

        int count = 0;
        for(int k=0; k<setPoint; k++) {
            for(int j=1+k; j<=C-k; j++) {
                if(intArr[k+1][j] == 0) {
                    intArr[k+1][j] = 1;
                    count++;
                    if(count == K) {
                        System.out.println((k+1) + " " + j);
                        return;
                    }
                } else {
                    break;
                }
            }
            for(int i=2+k; i<=R-k; i++) {
                if(intArr[i][C-k] == 0) {
                    intArr[i][C-k] = 1;
                    count++;
                    if(count == K) {
                        System.out.println(i + " " + (C-k));
                        return;
                    }
                } else {
                    break;
                }
            }
            for(int j=C-k-1; j>=k+1; j--) {
                if(intArr[R-k][j] == 0) {
                    intArr[R-k][j] = 1;
                    count++;
                    if(count == K) {
                        System.out.println((R-k) + " " + j);
                        return;
                    }
                } else {
                    break;
                }
            }
            for(int i=R-k-1; i>=k+2; i--) {
                if(intArr[i][k+1] == 0) {
                    intArr[i][k+1] = 1;
                    count++;
                    if(count == K) {
                        System.out.println(i + " " + (k+1));
                        return;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(0);
    }
}
