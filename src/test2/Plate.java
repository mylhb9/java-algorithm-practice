package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Plate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "zyxwvutsrqponmlkjihgfedcba";
        char[] charArr = alphabet.toCharArray();
        // 입력 배열
        char[] inputArr = sc.nextLine().toCharArray();

        // 스택
        Stack<Character> stack = new Stack<>();

        // 답안 리스트
        List<String> answerList = new ArrayList<>();

        // 알파벳 리스트
        List<Character> alphabetList = new ArrayList<>();
        for(int i=0; i<charArr.length; i++) {
            alphabetList.add(charArr[i]);
        }

        for(int i=0; i<inputArr.length; i++) {
            while(stack.size() != 0 || alphabetList.size() != 0) {
                if(alphabetList.size() != 0) {
                    if(inputArr[i] == alphabetList.get(alphabetList.size()-1)) {
                        stack.push(alphabetList.get(alphabetList.size()-1));
                        answerList.add("push");
                        alphabetList.remove(alphabetList.size()-1);
                        stack.pop();
                        answerList.add("pop");
                        break;
                    } else if(inputArr[i] > alphabetList.get(alphabetList.size()-1)) {
                        stack.push(alphabetList.get(alphabetList.size()-1));
                        answerList.add("push");
                        alphabetList.remove(alphabetList.size()-1);
                    } else {
                        if(!stack.empty()) {
                            char pivot = stack.pop();
                            answerList.add("pop");
                            if(pivot == inputArr[i]) {
                                break;
                            } else {
                                System.out.println("impossible");
                                return;
                            }
                        } else {
                            System.out.println("impossible");
                            return;
                        }
                    }
                } else {
                    if(!stack.empty()) {
                        char pivot = stack.pop();
                        answerList.add("pop");
                        if(pivot == inputArr[i]) {
                            break;
                        } else {
                            System.out.println("impossible");
                            return;
                        }
                    } else {
                        System.out.println("impossible");
                        return;
                    }
                }
            }
        }
        for(int i=0; i< answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }
}
