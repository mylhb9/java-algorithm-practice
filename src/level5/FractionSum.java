package level5;


import java.util.Scanner;

// 문제: 분자 분모가 모두 자연수인 두 분수의 합 또한 분자 분모가 자연수인 분수로 표현할 수 있다
// 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성해라
// 입력: 분자 분모 형태로 각 자연수가 30000 이하의 형태로 되는 프로그램을 만들어라
public class FractionSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 최소 공배수를 구한 뒤 각 분자에 각 분모가 최소공배수가 되도록 필요한 값을 곱해주고 더해줘서 계산해준다.
        String[] input1 = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");

        int firstSon = Integer.parseInt(input1[0]);
        int firstParent = Integer.parseInt(input1[1]);
        int secondSon = Integer.parseInt(input2[0]);
        int secondParent = Integer.parseInt(input2[1]);

        int gCF = 0;
        for(int i=1; i<=Math.min(firstParent, secondParent); i++) {
            if(firstParent % i == 0 && secondParent % i == 0) {
                gCF = i;
            }
        }

        int lCM = gCF * (firstParent / gCF) * (secondParent / gCF);

        int a = lCM / firstParent;
        int b = lCM / secondParent;

        int finalSon = firstSon * a + secondSon * b;
        int finalParent = lCM;


        // 2. 두 수를 기약 분수 형태로 만들어준다.
        int gCF2 = 0;
        for(int i=1; i<=Math.min(finalSon, finalParent); i++) {
            if(finalSon % i == 0 && finalParent % i == 0) {
                gCF2 = i;
            }
        }

        System.out.println(finalSon/gCF2 +" " + finalParent/gCF2);


    }
}
