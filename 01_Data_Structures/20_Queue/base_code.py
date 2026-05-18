from collections import deque

class Queue:
    def __init__(self):
        # 내부적으로 이중 연결 리스트 구조를 사용하여 O(1) 삽입/삭제를 보장합니다.
        self.queue = deque()

    def enqueue(self, item):
        """큐의 맨 뒤에 데이터를 추가합니다. / Add an item to the back of the queue."""
        self.queue.append(item)

    def dequeue(self):
        """큐의 맨 앞 데이터를 제거하고 반환합니다. / Remove and return the front item of the queue."""
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.queue.popleft()

    def peek(self):
        """큐의 맨 앞 데이터를 삭제하지 않고 조회합니다. / Return the front item without removing it."""
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.queue[0]

    def is_empty(self):
        """큐가 비어있는지 확인합니다. / Check if the queue is empty."""
        return len(self.queue) == 0

    def size(self):
        """큐에 쌓인 데이터의 개수를 반환합니다. / Return the number of items in the queue."""
        return len(self.queue)


# 사용 예시 (Usage Example)
if __name__ == "__main__":
    q = Queue()
    q.enqueue(10)
    q.enqueue(20)
    print(q.peek())      # Output: 10
    print(q.dequeue())   # Output: 10
    print(q.is_empty())  # Output: False