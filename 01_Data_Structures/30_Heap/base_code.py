class MinHeap:
    def __init__(self):
        self.heap = []

    def push(self, val):
        """데이터를 맨 뒤에 삽입한 후 부모 노드와 비교하며 위로 올립니다. / Insert and heapify up."""
        self.heap.append(val)
        self._heapify_up(len(self.heap) - 1) # 가장 마지막에 추가한 것을 부모와 비교하면서 순서 맞추기

    def pop(self):
        """루트(최솟값)를 꺼내고, 맨 뒤 원소를 루트로 옮긴 후 아래로 내리며 정렬합니다. / Pop min and heapify down."""
        if not self.heap:
            raise IndexError("Heap is empty")
        
        if len(self.heap) == 1: # 만약 1개 남다면, 자식과 비교 필요 없음
            return self.heap.pop() # pop하고 종료

        min_val = self.heap[0]
        self.heap[0] = self.heap.pop()  # 맨 뒤 원소를 루트 노드로 이동
        self._heapify_down(0) # 새로운 루트와 자기 자식들을 비교, 정렬에 맞을 때 까지 진행됨
        return min_val

    def peek(self): #push 할 때 이용
        """최솟값을 삭제하지 않고 확인합니다. / View the minimum value without removing."""
        if not self.heap:
            raise IndexError("Heap is empty")
        return self.heap[0]

    def _heapify_up(self, index): #pop 하고 난 후, 아래서 올라온 루트를 체크할 때 이용
        """자식 노드가 부모 노드보다 작으면 위치를 서로 바꿉니다. (부모 인덱스 = (자식-1)//2)"""
        parent = (index - 1) // 2
        if index > 0 and self.heap[index] < self.heap[parent]: # 자신의 인덱스가 루트가 아니고, 부모가 자식보다 클 경우(min-heap)
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index] # 서로 swap 하기
            self._heapify_up(parent) # swap 후 자식에서 부모가 된, 그 노드를 기준으로 다시 부모와 비교하기

    def _heapify_down(self, index):
        """자식 노드들 중 더 작은 값과 비교하여 부모 노드가 더 크면 아래로 내립니다."""
        smallest = index # 현재 인덱스를 가장 작은 값으로 함
        left = 2 * index + 1
        right = 2 * index + 2

        # 자식들 중 자기보다 작은 것을 찾음, 여기서는 오른쪽을 우선으로 하여 바꾸는 것을 확인 가능
        if left < len(self.heap) and self.heap[left] < self.heap[smallest]:
            smallest = left
        if right < len(self.heap) and self.heap[right] < self.heap[smallest]:
            smallest = right

        if smallest != index: # 만약 자신이 자기보다 작으면, swap이 필요함
            self.heap[index], self.heap[smallest] = self.heap[smallest], self.heap[index]
            self._heapify_down(smallest)

    def is_empty(self):
        return len(self.heap) == 0

    def size(self):
        return len(self.heap)


# 직접 구현 테스트
if __name__ == "__main__":
    h = MinHeap()
    h.push(15)
    h.push(5)
    h.push(10)
    print(h.pop())  # Output: 5
    print(h.peek()) # Output: 10