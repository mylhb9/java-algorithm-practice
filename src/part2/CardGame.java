package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int winA = 0;
        int winB = 0;

        String[] cardAs = sc.nextLine().split(" ");
        String[] cardBs = sc.nextLine().split(" ");
        List<Integer> cardAList = new ArrayList<>();
        List<Integer> cardBList = new ArrayList<>();

        for(int i=0; i<10; i++) {
            cardAList.add(Integer.parseInt(cardAs[i]));
            cardBList.add(Integer.parseInt(cardBs[i]));
        }

        for(int i=0; i<10; i++) {
            if(cardAList.get(i) > cardBList.get(i)) {
                winA++;
            } else if(cardAList.get(i) < cardBList.get(i)) {
                winB++;
            }
        }

        if(winA > winB) {
            System.out.println("A");
        } else if(winA < winB) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }
    }
}
