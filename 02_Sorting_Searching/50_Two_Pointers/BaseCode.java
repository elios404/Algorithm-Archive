import java.util.Arrays;

public class BaseCode {
    
    /**
     * 정렬된 배열에서 두 수의 합이 target이 되는 한 쌍을 찾습니다.
     * 배열이 정렬되어 있지 않다면 Arrays.sort()를 먼저 호출해야 합니다.
     */
    public static int[] twoPointersPairSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return new int[]{arr[left], arr[right]}; // 찾은 경우 배열로 반환
            } else if (currentSum < target) {
                left++; // 합을 키워야 하므로 왼쪽 포인터 이동
            } else {
                right--; // 합을 줄여야 하므로 오른쪽 포인터 이동
            }
        }
        
        return null; // 없는 경우 null 반환
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 5, 7, 11, 15}; // 정렬된 배열
        int target = 12;

        int[] result = twoPointersPairSum(data, target);
        
        if (result != null) {
            System.out.println("합이 " + target + "이 되는 두 수: " + Arrays.toString(result)); 
            // Output: [5, 7]
        } else {
            System.out.println("조건을 만족하는 쌍이 없습니다.");
        }
    }
}