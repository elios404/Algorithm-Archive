import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInterfaceUse {
    public static void main(String[] args) {
        // 1. ArrayDeque를 사용하는 방법 (가장 추천, 속도가 빠름)
        Queue<Integer> q = new ArrayDeque<>();

        // 2. LinkedList를 사용하는 방법 (가장 대중적)
        Queue<Integer> queue = new LinkedList<>();

        // 2. 데이터 삽입 / Enqueue -> O(1)
        q.offer(10);
        q.offer(20);
        q.offer(30);

        // 3. 맨 앞 데이터 확인 / Peek -> O(1)
        System.out.println("Front element: " + q.peek()); // Output: 10

        // 4. 데이터 꺼내기 / Dequeue -> O(1)
        System.out.println("Removed: " + q.poll()); // Output: 10
        System.out.println("Removed: " + q.poll()); // Output: 20

        // 5. 큐 정보 확인
        System.out.println("Current Size: " + q.size());  // Output: 1
        System.out.println("Is Empty?: " + q.isEmpty());   // Output: false
        
        // 6. 안전한 예외 처리 예시
        q.poll(); // 마지막 30 꺼냄
        System.out.println("Poll from empty queue: " + q.poll()); // 에러 없이 'null' 반환
    }
}
