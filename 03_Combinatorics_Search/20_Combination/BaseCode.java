import java.util.Arrays;

public class BaseCode {

    /**
     * arr 배열에서 r개를 뽑는 조합을 생성하는 메인 헬퍼 함수
     */
    public static void generateCombinations(int[] arr, int r) {
        int[] out = new int[r]; // 뽑힌 원소를 순서대로 담을 배열
        
        // start: 0번 인덱스부터 탐색 시작, depth: 현재 0개 뽑음
        backtrack(arr, out, 0, 0, r);
    }

    /**
     * 백트래킹을 이용한 조합 재귀 함수
     * @param start 탐색을 시작할 배열의 인덱스 (중복 선택 및 역방향 탐색 방지)
     * @param depth 현재까지 뽑은 원소의 개수
     */
    private static void backtrack(int[] arr, int[] out, int start, int depth, int r) {
        // 1. 종료 조건: 원하는 개수(r)만큼 다 뽑았다면 출력
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        // 2. 탐색: start부터 끝까지 확인 (이전 인덱스는 무시)
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i]; // 현재 깊이에 원소 저장
            
            // 3. 다음 원소를 뽑기 위해 재귀 호출 (다음 탐색은 i + 1부터)
            backtrack(arr, out, i + 1, depth + 1, r);
        }
    }

    // 사용 예시
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        int r = 2; // 4개 중 2개를 뽑는 조합
        
        System.out.println("자바 백트래킹을 이용한 조합:");
        generateCombinations(data, r);
    }
}