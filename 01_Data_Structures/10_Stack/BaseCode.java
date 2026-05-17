import java.util.ArrayList;
import java.util.EmptyStackException;

public class BaseCode<T> {
    private ArrayList<T> stack;

    public BaseCode() {
        this.stack = new ArrayList<>();
    }

    /**
     * 스택의 맨 위에 데이터를 추가합니다. / Push an item onto the top of the stack.
     */
    public void push(T item) {
        stack.add(item);
    }

    /**
     * 스택의 맨 위 데이터를 제거하고 반환합니다. / Remove and return the top item of the stack.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * 스택의 맨 위 데이터를 삭제하지 않고 조회합니다. / Return the top item without removing it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * 스택이 비어있는지 확인합니다. / Check if the stack is empty.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * 스택에 쌓인 데이터의 개수를 반환합니다. / Return the number of items in the stack.
     */
    public int size() {
        return stack.size();
    }

    // 사용 예시 (Usage Example)
    public static void main(String[] args) {
        BaseCode<Integer> s = new BaseCode<>();
        s.push(10);
        s.push(20);
        System.out.println(s.peek());     // Output: 20
        System.out.println(s.pop());      // Output: 20
        System.out.println(s.isEmpty());  // Output: false
    }
}