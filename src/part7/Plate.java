package part7;

import java.util.*;
import java.util.Stack;

public class Plate {
    public static void main(String[] args) {
        String alphabet = "zyxwvutsrqponmlkjihgfedcba";
        char[] alphabetArr = alphabet.toCharArray();
        // 알파벳 스택
        List<Character> alphabetList = new ArrayList<>();
        for(int i=0; i<alphabetArr.length; i++) {
            alphabetList.add(alphabetArr[i]);
        }

        Scanner sc = new Scanner(System.in);
        // 스택
        Stack<Character> stack = new Stack<>();
        // 입력 값
        char[] inputArr = sc.nextLine().toCharArray();
        // 출력용 리스트
        List<String> answerSheet = new ArrayList<>();

        for(int j=0; j<inputArr.length; j++) {
            while(alphabetList.size() !=0  || !stack.empty()) {
                if(alphabetList.size() != 0) {
                    if(alphabetList.get(alphabetList.size()-1) == inputArr[j]) {
                        stack.push(alphabetList.get(alphabetList.size()-1));
                        alphabetList.remove(alphabetList.size()-1);
                        answerSheet.add("push");
                        char pivot = stack.pop();
                        answerSheet.add("pop");
                        if(pivot == inputArr[j]) {
                            break;
                        } else {
                            System.out.println("impossible");
                            return;
                        }
                    } else if(alphabetList.get(alphabetList.size()-1) < inputArr[j]) {
                        stack.push(alphabetList.get(alphabetList.size()-1));
                        alphabetList.remove(alphabetList.size()-1);
                        answerSheet.add("push");
                    } else {
                        if(!stack.empty()) {
                            char pivot = stack.pop();
                            answerSheet.add("pop");
                            if(pivot == inputArr[j]) {
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
                        answerSheet.add("pop");
                        if(pivot == inputArr[j]) {
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
        for(int i=0; i<answerSheet.size(); i++) {
            System.out.println(answerSheet.get(i));
        }
    }
}