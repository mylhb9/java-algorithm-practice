package level17;

import java.util.Scanner;

public class DistanceBetweenTwoCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr11 = sc.nextLine().toCharArray();
        char[] arr22 = sc.nextLine().toCharArray();

        int N = arr22.length + 1;
        int M = arr11.length + 1;

        char[] arr2 = new char[N];
        for(int i=0; i<N; i++) {
            if(i == 0) {
                arr2[i] = ' ';
            } else {
                arr2[i] = arr22[i-1];
            }
        }
        char[] arr1 = new char[M];
        for(int i=0; i<M; i++) {
            if(i == 0) {
                arr1[i] = ' ';
            } else {
                arr1[i] = arr11[i-1];
            }
        }

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            arr[i][0] = i;

        }
        for(int i=0; i<M; i++) {
            arr[0][i] = i;

        }




        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                if(arr2[i] != arr1[j]) {
                    arr[i][j] = Math.min(arr[i-1][j], arr[i][j-1]) + 1;
                } else {
                    arr[i][j] = arr[i-1][j-1];
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
    }
}

//  a b c c a
//  a b c a

//       a  b  c  a  b  c  d
//    0  1  2  3  4  5  6  7
//  a 1  0  1  2  3  4  5  6
//  b 2  1  0  1  2  3  4  5
//  c 3  2  1  0  1  2  3  4
//  c 4  3  2  1  2  3  2  3
//  a 5  4  3  2  1  2  3  4
//  b 6  5  4  3  2  1  2  3
//  c 7  6  5  4  3  2  1  2