package part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColorPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] strArray = new String[N][4];
        Integer[][] intArray = new Integer[N][4];

        for(int i=0; i<N; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<4; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }
        Integer[][] colorPaper = new Integer[101][101];
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                colorPaper[i][j] = 0;
            }
        }

        for(int a=0; a<N; a++) {
            for(int i=intArray[a][0]; i<intArray[a][0]+intArray[a][2]; i++) {
                for(int j=intArray[a][1]; j<intArray[a][1]+intArray[a][3]; j++) {
                    colorPaper[i][j] = a+1;
                }
            }
        }

        List<Integer> countList = new ArrayList<>();
        for(int a=0; a<N; a++) {
            int count = 0;
            for(int i=0; i<101; i++) {
                for(int j=0; j<101; j++) {
                    if(colorPaper[i][j] == a+1) {
                        count++;
                    }
                }
            }
            countList.add(count);
        }

        for(int i=0; i<countList.size(); i++) {
            System.out.println(countList.get(i));
        }
    }
}
