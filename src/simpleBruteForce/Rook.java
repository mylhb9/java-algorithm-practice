package simpleBruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        int indexKingI = 0;
        int indexKingJ = 0;
        List<Integer> indexOtherI = new ArrayList<>();
        List<Integer> indexOtherJ = new ArrayList<>();
        List<Integer> indexObstacleI = new ArrayList<>();
        List<Integer> indexObstacleJ = new ArrayList<>();


        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(intArray[i][j] == 1) {
                    indexKingI = i;
                    indexKingJ = j;
                }
                if(intArray[i][j] == 2) {
                    indexOtherI.add(i);
                    indexOtherJ.add(j);
                }
                if(intArray[i][j] == 3) {
                    indexObstacleI.add(i);
                    indexObstacleJ.add(j);
                }
            }
        }




        for(int i=0; i<indexOtherI.size(); i++) {
            if(indexKingI == indexOtherI.get(i)) {
                if(indexKingJ < indexOtherJ.get(i)) {
                    for(int j=0; j<indexObstacleJ.size(); j++) {
                        if(indexKingJ < indexObstacleJ.get(j) &&  indexObstacleJ.get(j)< indexOtherJ.get(j)) {
                            System.out.println(0);
                            return;
                        } else {
                            System.out.println(1);
                            return;
                        }
                    }
                } else {
                    for(int j=0; j<indexObstacleJ.size(); j++) {
                        if(indexObstacleJ.get(j) < indexObstacleJ.get(j) && indexOtherJ.get(j) < indexKingJ) {
                            System.out.println(0);
                            return;
                        } else {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
            if(indexKingJ == indexOtherJ.get(i)) {
                if(indexKingI < indexOtherI.get(i)) {
                    for(int j=0; j<indexObstacleI.size(); j++) {
                        if(indexKingI < indexObstacleI.get(j) &&  indexObstacleI.get(j)< indexOtherI.get(j)) {
                            System.out.println(0);
                            return;
                        } else {
                            System.out.println(1);
                            return;
                        }
                    }
                } else {
                    for(int j=0; j<indexObstacleI.size(); j++) {
                        if(indexObstacleI.get(j) < indexObstacleI.get(j) && indexOtherI.get(j) < indexKingI) {
                            System.out.println(0);
                            return;
                        } else {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
        }


    }
}
