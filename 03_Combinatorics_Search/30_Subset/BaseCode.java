import java.util.ArrayList;
import java.util.List;

public class BaseCode {

    /**
     * 부분집합을 구하는 메인 헬퍼 함수
     */
    public static void generateSubsets(int[] arr) {
        boolean[] visited = new boolean[arr.length]; // 각 원소의 포함/미포함 상태
        backtrack(arr, visited, 0);
    }

    /**
     * 백트래킹을 이용한 부분집합 재귀 함수
     * @param index 현재 포함 여부를 결정할 배열의 인덱스
     */
    private static void backtrack(int[] arr, boolean[] visited, int index) {
        // 1. 종료 조건: 모든 원소에 대해 포함/미포함 결정을 내렸을 때
        if (index == arr.length) {
            printSubset(arr, visited);
            return;
        }

        // 2. 현재 원소를 부분집합에 '포함'하는 경우
        visited[index] = true;
        backtrack(arr, visited, index + 1);

        // 3. 현재 원소를 부분집합에 '포함하지 않는' 경우
        visited[index] = false;
        backtrack(arr, visited, index + 1);
    }

    /**
     * visited 배열이 true인 원소만 골라서 출력하는 헬퍼 함수
     */
    private static void printSubset(int[] arr, boolean[] visited) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                subset.add(arr[i]);
            }
        }
        System.out.println(subset);
    }

    // 사용 예시
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        
        System.out.println("자바 백트래킹을 이용한 부분집합:");
        generateSubsets(data);
    }
}