import java.util.Collections;
import java.util.PriorityQueue;

public class HeapInterfaceUse {
    public static void main(String[] args) {
        // 1. 기본 최소 힙 (Min Heap) 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 2. 최대 힙 (Max Heap) 선언 방법 (Collections.reverseOrder() 주입)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 값 삽입 -> O(log N)
        minHeap.offer(15);
        minHeap.offer(5);
        minHeap.offer(10);

        maxHeap.offer(15);
        maxHeap.offer(5);
        maxHeap.offer(10);

        // 결과 확인 및 추출
        System.out.println("Min Heap Peek: " + minHeap.peek()); // Output: 5
        System.out.println("Min Heap Pop: " + minHeap.poll());   // Output: 5

        System.out.println("Max Heap Peek: " + maxHeap.peek()); // Output: 15
        System.out.println("Max Heap Pop: " + maxHeap.poll());   // Output: 15
    }
}
