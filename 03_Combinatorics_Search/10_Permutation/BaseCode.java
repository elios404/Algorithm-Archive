import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseCode {

    /**
     * arr 배열에서 r개를 뽑는 순열을 생성하는 메인 헬퍼 함수
     */
    public static void generatePermutations(int[] arr, int r) {
        boolean[] visited = new boolean[arr.length]; // 원소 사용 여부 체크
        int[] out = new int[r]; // 뽑힌 원소를 순서대로 담을 배열 (path 역할)
        
        backtrack(arr, out, visited, 0, r);
    }

    /**
     * 백트래킹을 이용한 순열 재귀 함수
     * @param depth 현재까지 뽑은 원소의 개수 (트리의 깊이)
     */
    private static void backtrack(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        // 1. 종료 조건: 원하는 개수(r)만큼 다 뽑았다면 출력(또는 저장)
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        // 2. 탐색: 0번 인덱스부터 모든 원소를 확인
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {       // 아직 방문하지 않은(뽑지 않은) 원소라면
                visited[i] = true;   // 1. 방문 처리
                out[depth] = arr[i]; // 2. 현재 깊이에 원소 저장
                
                // 3. 다음 깊이로 이동 (재귀 호출)
                backtrack(arr, out, visited, depth + 1, r);
                
                // 4. 원래 상태로 복구 (백트래킹)
                visited[i] = false; 
            }
        }
    }

    // 사용 예시
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        int r = 2; // 3개 중 2개를 뽑는 순열
        
        System.out.println("자바 백트래킹을 이용한 순열:");
        generatePermutations(data, r);
    }
}