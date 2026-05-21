import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BaseCode {
    private ArrayList<Integer> heap; // 크기를 정하지 않고, 사용하는 arrayList 를 사용

    public BaseCode() {
        this.heap = new ArrayList<>();
    }

    public void push(int val) {
        heap.add(val); // 가장 뒤에 새로운 원소를 추가하고
        heapifyUp(heap.size() - 1); // 마지막 인덱스에 대해서 부모보다 작을 때 위로 올리는 과정 진행
    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minVal = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1)); // 맨 뒤 요소를 루트로 이동
        heapifyDown(0); // 루트로 새로 올라온 값과 자식들을 비교해서 정렬을 유지
        return minVal;
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2; //부모 인덱스에 대해서 
        if (index > 0 && heap.get(index) < heap.get(parent)) { //자기 자신이 루트가 아니고, 부모가 나보다 크다면
            swap(index, parent); // swap 하는 sub function 구현
            heapifyUp(parent); // recursion
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) { // 만약 바꿀 필요가 있다면, swap 하고 recursion
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        BaseCode h = new BaseCode();
        h.push(15);
        h.push(5);
        h.push(10);
        System.out.println(h.pop());  // Output: 5
        System.out.println(h.peek()); // Output: 10
    }
}