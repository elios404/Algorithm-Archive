import java.util.Arrays;

public class BaseCode {
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗의 위치를 찾고 배열을 분할합니다.
            int pivotIndex = partition(arr, low, high);

            // 피벗을 제외한 왼쪽과 오른쪽 부분 배열을 재귀적으로 정렬합니다.
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 가장 오른쪽 값을 피벗으로 설정
        int i = low - 1;       // 피벗보다 작은 값들이 들어갈 위치 포인터

        // low부터 high-1까지 순회하며 피벗보다 작은 값을 왼쪽으로 몹니다.
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // 피벗을 작은 값들의 바로 오른쪽(최종 위치)으로 이동시킵니다.
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 사용 예시
    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("정렬 전: " + Arrays.toString(data));
        quickSort(data);
        System.out.println("정렬 후: " + Arrays.toString(data));
    }
}