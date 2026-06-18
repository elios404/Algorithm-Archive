public class BaseCode {

    /**
     * 크기가 K인 연속된 부분 배열 중 가장 큰 합을 반환합니다.
     */
    public static int slidingWindowMaxSum(int[] arr, int k) {
        int n = arr.length;
        
        // 예외 처리
        if (n < k) {
            throw new IllegalArgumentException("배열의 길이가 K보다 작습니다.");
        }

        // 1. 첫 번째 창문(초기 윈도우)의 합 계산
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;

        // 2. 창문을 한 칸씩 이동하며 상태 갱신
        for (int i = k; i < n; i++) {
            // 새로 들어온 값(arr[i])은 더하고, 창문 밖으로 밀려난 값(arr[i - k])은 뺌
            windowSum += arr[i] - arr[i - k];
            
            // 최대 합 갱신 (Math.max를 사용하여 간결하게 표현)
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;

        int result = slidingWindowMaxSum(data, windowSize);
        System.out.println("크기가 " + windowSize + "인 부분 배열의 최대 합: " + result); 
        // Output: 9
    }
}