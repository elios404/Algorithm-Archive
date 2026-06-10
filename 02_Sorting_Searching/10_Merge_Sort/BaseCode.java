import java.util.Arrays;

public class BaseCode {
    
    /**
     * 병합 정렬의 시작점. 임시 배열을 한 번만 생성하여 넘겨줍니다.
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // (left + right) / 2 와 같지만 오버플로우 방지
            
            // 1. 반으로 나누어 각각 정렬 (Divide)
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid + 1, right);
            
            // 2. 정렬된 두 부분 배열을 병합 (Merge)
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // 임시 배열에 현재 범위의 데이터 복사
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // 왼쪽 부분 배열의 포인터
        int j = mid + 1;   // 오른쪽 부분 배열의 포인터
        int k = left;      // 원본 배열에 덮어쓸 위치 포인터

        // 두 부분 배열을 비교하여 더 작은 값을 원본 배열에 채워 넣음
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) { // 안정 정렬 유지
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열에 남은 원소가 있다면 일괄 복사
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    // 사용 예시
    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("정렬 전: " + Arrays.toString(data));
        mergeSort(data);
        System.out.println("정렬 후: " + Arrays.toString(data));
    }
}