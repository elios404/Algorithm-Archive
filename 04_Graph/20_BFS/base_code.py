from collections import deque

def bfs(graph, start, visited, result):
    """
    큐(deque)를 활용한 BFS 뼈대 코드
    """
    # 1. 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    
    # 2. 현재 노드를 방문 처리
    visited[start] = True
    
    # 3. 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 결과 리스트에 추가
        v = queue.popleft()
        result.append(v)
        
        # 아직 방문하지 않은 인접한 원소들을 큐에 모두 삽입하고 방문 처리
        for next_node in graph[v]:
            if not visited[next_node]:
                queue.append(next_node)
                visited[next_node] = True # 큐에 넣을 때 방문 처리를 해야 중복 삽입을 막을 수 있음!

# 사용 예시
if __name__ == "__main__":
    # DFS와 동일한 그래프 구조
    graph = [
        [],
        [2, 3, 8], # 1번 노드
        [1, 7],    # 2번 노드
        [1, 4, 5], # 3번 노드
        [3, 5],    # 4번 노드
        [3, 4],    # 5번 노드
        [7],       # 6번 노드
        [2, 6],    # 7번 노드
        [1]        # 8번 노드
    ]
    
    visited = [False] * len(graph)
    bfs_result = []
    
    # 1번 노드부터 BFS 탐색 시작
    bfs(graph, 1, visited, bfs_result)
    
    print("BFS 탐색 순서:", bfs_result)
    # Output: [1, 2, 3, 8, 7, 4, 5, 6] 
    # (DFS 결과 [1, 2, 7, 6, 3, 4, 5, 8]와 비교해보세요!)