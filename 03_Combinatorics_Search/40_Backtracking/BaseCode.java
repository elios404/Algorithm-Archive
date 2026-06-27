import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseCode {

    public static List<int[]> solveNQueens(int n) {
        List<int[]> result = new ArrayList<>();
        int[] board = new int[n]; 
        
        backtrack(result, board, 0, n);
        return result;
    }

    /**
     * @param row 현재 퀸을 놓으려고 시도하는 행
     */
    private static void backtrack(List<int[]> result, int[] board, int row, int n) {
        // 1. 종료 조건: N개의 퀸을 모두 배치 완료
        if (row == n) {
            result.add(board.clone()); // 배열 복사본 저장
            return;
        }

        // 2. 탐색: 현재 행(row)의 0열부터 n-1열까지 시도
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) { // ✨ 가지치기 (Pruning)
                board[row] = col;           // 퀸 배치
                
                backtrack(result, board, row + 1, n); // 다음 행으로 이동
                
                // 자바는 값을 덮어쓰는 구조라 명시적인 복구 코드(board[row] = 0)가 없어도
                // 다음 for문 루프에서 덮어씌워지며 자연스럽게 백트래킹이 됩니다.
            }
        }
    }

    /**
     * (row, col)에 퀸을 놓을 수 있는지 확인합니다.
     */
    private static boolean isValid(int[] board, int row, int col) {
        // 현재 행(row) 이전까지 배치된 퀸들과 충돌하는지 검사
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나 || 대각선에 있는 경우 (행의 차이 == 열의 차이)
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // 사용 예시
    public static void main(String[] args) {
        int n = 4;
        List<int[]> solutions = solveNQueens(n);

        System.out.println(n + "x" + n + " 체스판의 N-Queen 해답 개수: " + solutions.size() + "개");
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("해답 " + (i + 1) + ": " + Arrays.toString(solutions.get(i)));
        }
    }
}