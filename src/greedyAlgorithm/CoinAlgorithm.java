package greedyAlgorithm;

import java.util.ArrayList;

public class CoinAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();

        for(int i=0; i<coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinList.get(i) * coinNum;
            details.add(coinNum);
            System.out.println(coinList.get(i) + "원: " + coinNum + "개");
        }
        System.out.println("총 동전 갯수: " + totalCoinCount);
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>();
        coinList.add(500);
        coinList.add(100);
        coinList.add(50);
        coinList.add(1);

        CoinAlgorithm ga = new CoinAlgorithm();
        ga.coinFunc(4720, coinList);
    }
}
