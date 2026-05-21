import heapq

def heap_example():
    # 파이썬의 heapq는 기본적으로 '최소 힙(Min Heap)'으로 동작합니다.
    min_heap = []

    # 1. 원소 삽입 -> O(log N)
    heapq.heappush(min_heap, 15)
    heapq.heappush(min_heap, 5)
    heapq.heappush(min_heap, 10)

    # 2. 최솟값 확인(Peek) -> O(1)
    print("Min Heap Peek:", min_heap[0])  # Output: 5

    # 3. 원소 최솟값 추출(Pop) -> O(log N)
    print("Min Heap Pop:", heapq.heappop(min_heap))  # Output: 5


    # [응용] 최대 힙(Max Heap)을 구현해야 할 때는 부호를 반대로(-) 넣습니다.
    max_heap = []
    
    # 값을 넣을 때 마이너스(-) 부호를 붙여서 우선순위를 뒤집습니다.
    heapq.heappush(max_heap, -15)
    heapq.heappush(max_heap, -5)
    heapq.heappush(max_heap, -10)

    # 꺼낼 때 다시 마이너스(-) 부호를 붙여 원래 값으로 복원합니다.
    print("Max Heap Pop:", -heapq.heappop(max_heap))  # Output: 15 (가장 큰 값)

if __name__ == "__main__":
    heap_example()