package simpleBruteForce;

import java.util.Scanner;

public class ColorPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받은 정수 N
        int N = Integer.parseInt(sc.nextLine());
        // N X 4 String 배열
        String[][] strArray = new String[N][4];
        Integer[][] intArray = new Integer[N][4];
        for(int i=0; i<N; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        // N X 4 Integer 배열
        for(int i=0; i<N; i++) {
            for(int j=0; j<4; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        // 0, 1 열은 (a, b) 좌표를 나타내고 2, 3 열은 너비(w)와 높이(h)를 나타냄

        // 101 X 101 색종이를 만들자
        Integer[][] colorPaper = new Integer[101][101];
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                colorPaper[i][j] = 0;
            }
        }

        Integer[] area = new Integer[N];
        for(int i=0; i<N; i++) {
            area[i] = 0;
        }


        // 색종이를 색칠하기
        for(int p=0; p<N; p++) {
            for(int i=intArray[p][0]; i<intArray[p][0]+intArray[p][2]; i++) {
                for(int j=intArray[p][1]; j<intArray[p][1]+intArray[p][3]; j++){
                    colorPaper[i][j] = p+1;
                }
            }
        }

        for(int p=0; p<N; p++) {
            for(int i=intArray[p][0]; i<intArray[p][0]+intArray[p][2]; i++) {
                for(int j=intArray[p][1]; j<intArray[p][1]+intArray[p][3]; j++){
                    if(colorPaper[i][j] == p+1) {
                        area[p]++;
                    }
                }
            }
        }

        // 색종이 넓이 출력하기
        for(int i=0; i<N; i++) {
            System.out.println(area[i]);
        }
    }
}
