package part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] strArr = new String[8][8];
        for(int i=0; i<8; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }

        List<Integer> indexIList = new ArrayList<>();
        List<Integer> indexJList = new ArrayList<>();
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(strArr[i][j].equals("2")) {
                    indexIList.add(i);
                    indexJList.add(j);
                }
            }
        }

        for(int a=0; a<indexIList.size(); a++) {

            for(int i=indexIList.get(a); i<8; i++) {
                if(strArr[i][indexJList.get(a)].equals("3")) {
                    break;
                } else if(strArr[i][indexJList.get(a)].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=indexIList.get(a)-1; i>=0; i--) {
                if(strArr[i][indexJList.get(a)].equals("3")) {
                    break;
                } else if(strArr[i][indexJList.get(a)].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=indexJList.get(a); i<8; i++) {
                if(strArr[indexIList.get(a)][i].equals("3")) {
                    break;
                } else if(strArr[indexIList.get(a)][i].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=indexJList.get(a)-1; i>=0; i--) {
                if(strArr[indexIList.get(a)][i].equals("3")) {
                    break;
                } else if(strArr[indexIList.get(a)][i].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }

        }
        System.out.println(0);

    }
}
