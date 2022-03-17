package part6;

import java.util.Scanner;
public class SolvePermutation {

    int n;
    int r;
    char[] result = new char[10];
    String answer = "";
    boolean[] checkArr = {false, false, false, false, false, false, false, false, false, false};

    public void getResult(int x) {
        if(x >= r) {
            for(int i=0; i<result.length; i++) {
                if(result[i] != 0) {
                    answer+=result[i];
                }
            }
            System.out.println(answer);
            answer="";
        } else {
            for(int i=0; i<n; i++) {
                char alpha = (char) (i + 'a');
                if(!checkArr[i]) {
                    result[x] = alpha;
                    checkArr[i] = true;
                    getResult(x+1);
                    result[x] = 0;
                    checkArr[i] = false;
                }
            }
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String [] strArr = sc.nextLine().split(" ");

        int n = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);
        SolvePermutation m = new SolvePermutation();
        m.n = n;
        m.r = r;
        m.getResult(0);
    }
}