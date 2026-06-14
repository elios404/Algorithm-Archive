public class BaseCode {
    
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // (low + high) / 2를 하면 배열이 엄청 클 때 int 오버플로우가 발생할 수 있습니다.
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // 찾았을 때 인덱스 반환
            } else if (arr[mid] > target) {
                high = mid - 1; // 타겟이 중간값보다 작으므로 왼쪽 탐색
            } else {
                low = mid + 1;  // 타겟이 중간값보다 크므로 오른쪽 탐색
            }
        }
        
        return -1; // 찾지 못함
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 6, 8, 10, 12, 14, 16}; // 정렬된 배열
        int target = 10;
        
        int result = binarySearch(data, target);
        if (result != -1) {
            System.out.println("Target " + target + " is at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
    }
}