package level11;

// 문제: 접시
// 접시 a, b, c, d 가 있고, 알파벳 순으로 한쪽이 막혀있는 세척기에 들어간다
// b a c d 순으로 꺼내기 위해서는 push push pop pop push pop push pop
// 세척기에서 꺼내는 순서가 주어질 때, 그 동작을 출력하는 프로그램을 작성
// 주어진 순서대로 접시를 꺼낼 수 없다면 impossible 을 출력하라

// 입력: 첫째 줄에 소문자 알파벳이 주어짐
// 알파벳 소문자는 최대 26개이며, 중복된 소문자 알파벳은 입력되지 않음

// 출력: 접시를 꺼내는 것이 가능한 경우 push, pop의 순서를 출력
// 이것이 불가능하다면 impossible 을 출력한다

// 도중에 cbaedfg
import java.util.*;

public class Plate {
    static List<String> answerList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] resultArr = sc.nextLine().toCharArray();
        int length = resultArr.length;

        Stack<Character> inputStack = new Stack<>();
        for(int i=length-1; i>=0; i--) {
            inputStack.push((char) ('a' + i));
        }
        // resultArr : d a b c
        // output : d
        // stack : a b c
        // inputArr : a b c d
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            if(inputStack.peek() != resultArr[0]) {
                stack.push(inputStack.pop());
                answerList.add("push");
            } else{
                stack.push(inputStack.pop());
                answerList.add("push");
                stack.pop();
                answerList.add("pop");
                break;
            }
        }

        for(int i=1; i<length; i++) {
            if(!stack.empty()) {
                if(resultArr[i] == stack.peek()) {
                    stack.pop();
                    answerList.add("pop");
                } else { // 스택이 비어있지 않고
                    if(!inputStack.empty()) {
                        if(resultArr[i] <= inputStack.peek()) {
                            stack.push(inputStack.pop());
                            answerList.add("push");
                            if(stack.peek() == resultArr[i]) {
                                stack.pop();
                                answerList.add("pop");
                            }
                        } else {
                            System.out.println("impossible");
                            return;
                        }
                    } else { // inputStack 이 비어있고
                        System.out.println("impossible");
                        return;
                    }
                }
            } else {
                if(!inputStack.empty()) {
                    if(resultArr[i] <= inputStack.peek()) {
                        stack.push(inputStack.pop());
                        answerList.add("push");

                        if(stack.peek() == resultArr[i]) {
                            stack.pop();
                            answerList.add("pop");
                        } else {
                            System.out.println("impossible");
                            return;
                        }

                    } else {
                        for(int j=0; j<length; j++) {
                            if(!inputStack.empty()) {
                                if(inputStack.peek() != resultArr[i]) {
                                    stack.push(inputStack.pop());
                                    answerList.add("push");
                                } else{
                                    stack.push(inputStack.pop());
                                    answerList.add("push");
                                    stack.pop();
                                    answerList.add("pop");
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("impossible");
                    return;
                }
            }
        }
        for(int i=0; i<answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }
}
