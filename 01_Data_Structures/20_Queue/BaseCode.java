import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BaseCode<T> {
    private ArrayList<T> queue;
    private int head = 0; // 맨 앞 데이터의 위치를 가리키는 포인터

    public BaseCode() {
        this.queue = new ArrayList<>();
    }

    /**
     * 큐의 맨 뒤에 데이터를 추가합니다. / Add an item to the back of the queue.
     */
    public void enqueue(T item) {
        queue.add(item);
    }

    /**
     * 큐의 맨 앞 데이터를 제거하고 반환합니다. / Remove and return the front item of the queue.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = queue.get(head);
        head++; // 실제로 지우지 않고 포인터만 이동하여 O(1) 유지
        return item;
    }

    /**
     * 큐의 맨 앞 데이터를 삭제하지 않고 조회합니다. / Return the front item without removing it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.get(head);
    }

    /**
     * 큐가 비어있는지 확인합니다. / Check if the queue is empty.
     */
    public boolean isEmpty() {
        return head >= queue.size();
    }

    /**
     * 큐에 쌓인 데이터의 개수를 반환합니다. / Return the number of items in the stack.
     */
    public int size() {
        return queue.size() - head;
    }

    // 사용 예시 (Usage Example)
    public static void main(String[] args) {
        BaseCode<Integer> q = new BaseCode<>();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.peek());     // Output: 10
        System.out.println(q.dequeue());  // Output: 10
        System.out.println(q.isEmpty());  // Output: false
    }
}