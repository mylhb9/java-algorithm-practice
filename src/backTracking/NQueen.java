package backTracking;

import java.util.ArrayList;

public class NQueen {
    public boolean isAvailable(ArrayList<Integer> candidatee, Integer currentCol) {
        // currentRow 는 다음에 올 행의 인덱스 번호
        Integer currentRow = candidatee.size();
        for(int i=0; i<currentRow; i++) {
            if((candidatee.get(i) == currentCol) || ((Math.abs(candidatee.get(i) - currentCol)) == currentRow - i)) {
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currenCandidate) {
        // N은 실제 행 번호(N X N 생각하면 된다.), currentRow 는 다음으로 선택할 행의 인덱스 값
        if(currentRow == N) {
            System.out.println(currenCandidate);
            return;
        }

        for(int i=0; i<N; i++) {
            if(this.isAvailable(currenCandidate, i)) {
                currenCandidate.add(i);
                this.dfsFunc(N, currentRow + 1, currenCandidate);
                // 이어져 갈 노드가 없어서 해당 루트를 삭제 (마지막으로 넣은걸 삭제해야하므로 currendCandidate.size() - 1 을 제거함)
                currenCandidate.remove(currenCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<>());
    }
}
