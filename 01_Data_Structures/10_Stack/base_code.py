class Stack:
    def __init__(self):
        self.stack = []

    def push(self, item):
        """스택의 맨 위에 데이터를 추가 / Push an item onto the top of the stack."""
        self.stack.append(item)

    def pop(self):
        """스택의 맨 위 데이터를 제거하고 반환 / Remove and return the top item of the stack."""
        if self.is_empty():
            raise IndexError("Stack is empty")
        return self.stack.pop()

    def peek(self):
        """스택의 맨 위 데이터를 삭제하지 않고 조회 / Return the top item without removing it."""
        if self.is_empty():
            raise IndexError("Stack is empty")
        return self.stack[-1]

    def is_empty(self):
        """스택이 비어있는지 확인 / Check if the stack is empty."""
        return len(self.stack) == 0

    def size(self):
        """스택에 쌓인 데이터의 개수를 반환 / Return the number of items in the stack."""
        return len(self.stack)


# 사용 예시 (Usage Example)
if __name__ == "__main__":
    s = Stack()
    s.push(10)
    s.push(20)
    print(s.peek())      # Output: 20
    print(s.pop())       # Output: 20
    print(s.is_empty())  # Output: False