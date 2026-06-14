import java.util.Arrays;

public class BinarySearchUse {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9}; // 반드시 정렬되어 있어야 함
        
        // 1. 값이 존재할 때: 해당 인덱스 반환
        int indexFound = Arrays.binarySearch(arr, 5);
        System.out.println("Index of 5: " + indexFound); // Output: 2

        // 2. 값이 존재하지 않을 때: -(들어갈 위치) - 1 반환
        // 예: 6을 찾는다면 5와 7 사이인 인덱스 3에 들어가야 함. -> -(3) - 1 = -4 반환
        int indexNotFound = Arrays.binarySearch(arr, 6);
        System.out.println("Index of 6: " + indexNotFound); // Output: -4
        
        // [실전 꿀팁] 찾지 못한 값의 실제 '삽입 위치' 복원하기
        if (indexNotFound < 0) {
            int insertionPoint = -(indexNotFound + 1);
            System.out.println("If we insert 6, it should be at index: " + insertionPoint); // Output: 3
        }
    }
}