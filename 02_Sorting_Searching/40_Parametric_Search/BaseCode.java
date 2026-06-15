import java.util.Arrays;

public class BaseCode {

    /**
     * 결정 함수 (Decision Function)
     * mid(현재 탐색 중인 길이)로 잘랐을 때 목표 개수(target) 이상이 나오는지 확인합니다.
     */
    private static boolean check(long mid, int[] data, int target) {
        long count = 0;
        for (int length : data) {
            count += length / mid;
        }
        return count >= target;
    }

    public static long parametricSearch(int[] data, int target) {
        // 1. 정답이 될 수 있는 최소 범위와 최대 범위 설정 (탐색 범위가 넓으므로 long 권장)
        long low = 1;
        long high = Arrays.stream(data).max().getAsInt();
        long result = 0; // 최적의 답을 저장할 변수

        // 2. 이분 탐색 시작
        while (low <= high) {
            long mid = low + (high - low) / 2;

            // 3. 조건 검사 후 범위 조절
            if (check(mid, data, target)) {
                result = mid;     // 조건을 만족하므로 기록
                low = mid + 1;    // 최댓값을 찾아야 하므로 길이를 더 늘려봄 (오른쪽 탐색)
            } else {
                high = mid - 1;   // 개수가 부족하므로 길이를 줄여야 함 (왼쪽 탐색)
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] cables = {802, 743, 457, 539};
        int neededCables = 11;

        long maxLength = parametricSearch(cables, neededCables);
        System.out.println("조건을 만족하는 최대 랜선 길이: " + maxLength); // Output: 200
    }
}