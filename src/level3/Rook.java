package level3;

import java.util.*;

public class Rook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] inputArr = new String[8][8];

        for(int i=0; i<8; i++) {
            inputArr[i] = sc.nextLine().split(" ");
        }
        List<Integer> rookX = new ArrayList<>();
        List<Integer> rookY = new ArrayList<>();
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(inputArr[i][j].equals("2")) {
                    rookX.add(i);
                    rookY.add(j);
                }
            }
        }
        for(int k = 0; k<rookX.size(); k++) {
            for(int i=rookX.get(k)+1; i<8; i++) {
                if(inputArr[i][rookY.get(k)].equals("2") || inputArr[i][rookY.get(k)].equals("3")) {
                    break;
                }
                if(inputArr[i][rookY.get(k)].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=rookX.get(k)-1; i>=0; i--) {
                if(inputArr[i][rookY.get(k)].equals("2") || inputArr[i][rookY.get(k)].equals("3")) {
                    break;
                }
                if(inputArr[i][rookY.get(k)].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=rookY.get(k)+1; i<8; i++) {
                if(inputArr[rookX.get(k)][i].equals("2") || inputArr[rookX.get(k)][i].equals("3")) {
                    break;
                }
                if(inputArr[rookX.get(k)][i].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
            for(int i=rookY.get(k)-1; i>=0; i--) {
                if(inputArr[rookX.get(k)][i].equals("2") || inputArr[rookX.get(k)][i].equals("3")) {
                    break;
                }
                if(inputArr[rookX.get(k)][i].equals("1")) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);

    }
}
