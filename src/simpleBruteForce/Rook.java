package simpleBruteForce;

import java.util.*;

public class Rook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] strArray = new String[8][8];
        Integer[][] intArray = new Integer[8][8];
        for(int i=0; i<8; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        int kingX = 0;
        int kingY = 0;
        List<Integer> rockPositionsX = new ArrayList<>();
        List<Integer> rockPositionsY = new ArrayList<>();
        List<Integer> obstaclePositionsX = new ArrayList<>();
        List<Integer> obstaclePositionsY = new ArrayList<>();


        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(intArray[i][j] == 1) {
                    kingX = i;
                    kingY = j;
                }

                if(intArray[i][j] == 2) {
                    rockPositionsX.add(i);
                    rockPositionsY.add(j);
                }

                if(intArray[i][j] == 3) {
                    obstaclePositionsX.add(i);
                    obstaclePositionsY.add(j);
                }
            }
        }

        for(int j=rockPositionsY.get(0); j<8; j++) {
            if(intArray[rockPositionsX.get(0)][j] == 3 || intArray[rockPositionsX.get(0)][j] == 2) {
                System.out.println(0);
                break;
            }
            if(intArray[rockPositionsX.get(0)][j] == 1) {
                System.out.println(1);
            }
        }

        for(int j=rockPositionsY.get(0); j>0; j--) {
            if(intArray[rockPositionsX.get(0)][j] == 3 || intArray[rockPositionsX.get(0)][j] == 2) {
                System.out.println(0);
                break;
            }
            if(intArray[rockPositionsX.get(0)][j] == 1) {
                System.out.println(1);
            }
        }
        for(int i=rockPositionsX.get(0); i<8; i++) {
            if(intArray[rockPositionsY.get(0)][i] == 3 || intArray[rockPositionsY.get(0)][i] == 2) {
                System.out.println(0);
                break;
            }
            if(intArray[rockPositionsY.get(0)][i] == 1) {
                System.out.println(1);
            }
        }
        for(int i=rockPositionsX.get(0); i>0; i--) {
            if(intArray[rockPositionsY.get(0)][i] == 3 || intArray[rockPositionsY.get(0)][i] == 2) {
                System.out.println(0);
                break;
            }
            if(intArray[rockPositionsY.get(0)][i] == 1) {
                System.out.println(1);
            }
        }

        try{
            for(int j=rockPositionsY.get(1); j<8; j++) {
                if(intArray[rockPositionsX.get(1)][j] == 3 || intArray[rockPositionsX.get(1)][j] == 2) {
                    System.out.println(0);
                    break;
                }
                if(intArray[rockPositionsX.get(1)][j] == 1) {
                    System.out.println(1);
                }
            }

            for(int j=rockPositionsY.get(1); j>0; j--) {
                if(intArray[rockPositionsX.get(1)][j] == 3 || intArray[rockPositionsX.get(1)][j] == 2) {
                    System.out.println(0);
                    break;
                }
                if(intArray[rockPositionsX.get(1)][j] == 1) {
                    System.out.println(1);
                }
            }
            for(int i=rockPositionsX.get(1); i<8; i++) {
                if(intArray[rockPositionsY.get(1)][i] == 3 || intArray[rockPositionsY.get(1)][i] == 2) {
                    System.out.println(0);
                    break;
                }
                if(intArray[rockPositionsY.get(1)][i] == 1) {
                    System.out.println(1);
                }
            }
            for(int i=rockPositionsX.get(1); i>0; i--) {
                if(intArray[rockPositionsY.get(1)][i] == 3 || intArray[rockPositionsY.get(1)][i] == 2) {
                    System.out.println(0);
                    break;
                }
                if(intArray[rockPositionsY.get(1)][i] == 1) {
                    System.out.println(1);
                }
            }
        } catch (Exception e) {

        }


    }
}
