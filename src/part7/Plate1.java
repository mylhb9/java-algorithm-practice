package part7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Plate1 {
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
            while(!stack.empty() || alphabetList.size() != 0) {
                if(alphabetList.get(alphabetList.size()-1) < inputArr[i]) {
                    stack.push(alphabetList.get(alphabetList.size()-1));
                    alphabetList.remove(alphabetList.size()-1);
                    answerList.add("push");
                } else if(alphabetList.get(alphabetList.size()-1) == inputArr[i]) {
                    stack.push(alphabetList.get(alphabetList.size()-1));
                    alphabetList.remove(alphabetList.size()-1);
                    answerList.add("push");
                    stack.pop();
                    answerList.add("pop");
                    break;
                } else {
                    char pivot = stack.pop();
                    if(pivot != alphabetList.get(alphabetList.size()-1)) {
                        System.out.println("impossible");
                        return;
                    } else {
                        answerList.add("pop");
                        break;
                    }

                }
            }
        }
        System.out.println(answerList);

    }
}
