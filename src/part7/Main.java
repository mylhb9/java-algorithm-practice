package part7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String alphabet = "zyxwvutsrqponmlkjihgfedcba";
        char[] alphabetArr = alphabet.toCharArray();
        List<Character> alphabetList = new ArrayList<>();
        for(int i=0; i<alphabetArr.length; i++) {
            alphabetList.add(alphabetArr[i]);
        }

        Scanner sc = new Scanner(System.in);

        List<String> answerList = new ArrayList<>();
        char[] inputArr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<inputArr.length; i++) {
            for(int j=alphabetList.size()-1; j>=0; j--) {
                if(alphabetList.get(j) < inputArr[i]) {
                    stack.push(alphabetList.get(j));
                    alphabetList.remove(j);
                    answerList.add("push");
                } else if(alphabetList.get(j) == inputArr[i]) {
                    stack.push(alphabetList.get(j));
                    alphabetList.remove(j);
                    answerList.add("push");
                    stack.pop();
                    answerList.add("pop");
                    break;
                } else {
                    char pivot = stack.pop();
                    if(pivot != alphabetList.get(j)) {
                        System.out.println("impossible");
                        return;
                    }
                    answerList.add("pop");
                }
            }
        }
        System.out.println(answerList);

    }
}
