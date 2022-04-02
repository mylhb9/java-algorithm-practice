package part9;

import java.util.Scanner;

public class MakeNumber {

    Long[] notes;
    public long makeNum(int x) {
        if(x == 1) {
            return 1;
        } else if(x == 2) {
            return 2;
        } else if(x == 3) {
            return 4;
        } else {
            if(notes[x] != null) {
                return notes[x];
            }
            notes[x] = (makeNum(x-1) % 1000007 + makeNum(x-2) % 1000007 + makeNum(x-3) % 1000007) % 1000007;
            return notes[x] % 1000007;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        MakeNumber m  = new MakeNumber();
        m.notes = new Long[1000010];
        System.out.println(m.makeNum(N));
    }
}
