package simpleBruteForce;

import java.util.*;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[][] strArray = new String[N][5];

        // 학생별 최대 횟수를 담을 공간을 만들고 초기화 해줌

        Map<Integer, Set<Integer>> myMap = new HashMap<>();
        for(int i=0; i<N; i++) {
            myMap.put(i, new HashSet<>());
        }

        for(int i=0; i<N; i++) {
            strArray[i] = sc.nextLine().split(" ");
        }

        // 같은 반인 경우 같은 반인 학생에게 1 횟수 더해줌
        for(int j=0; j<5; j++) {
            for(int i=0; i<N; i++) {
                for(int k=0; k<N; k++) {
                    if(strArray[i][j].equals(strArray[k][j])) {
                        if(i==k) {
                            continue;
                        }
                        myMap.get(i).add(k);
                    }
                }
            }
        }

        // 배열의 크기를 비교하여 제일 큰 값을 선택하고 해당 값의 행 번호로 학생을 뽑아냄 (최대 값이 중복될 시, 최소 행번호 + 1 을 고름)
        int max = 0;
        int studentNo = 1;
        for(int i=0; i<N; i++) {
            if(max < myMap.get(i).size()) {
                max = myMap.get(i).size();
                studentNo = i + 1;
            }
        }
        System.out.println(studentNo);
    }
}
