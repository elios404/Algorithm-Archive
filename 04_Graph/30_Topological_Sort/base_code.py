from collections import deque

def topological_sort(v, edges):
    """
    큐를 활용한 위상 정렬 (Kahn's Algorithm) 상세 구현
    """
    # 1. 진입차수 배열 초기화 (0으로 세팅) 및 그래프 인접 리스트 생성
    indegree = [0] * (v + 1)
    graph = [[] for _ in range(v + 1)]

    # 2. 방향 그래프 간선 정보 입력 및 진입차수 계산
    for a, b in edges:
        graph[a].append(b) # 정점 A에서 B로 이동 가능
        indegree[b] += 1   # 정점 B로 들어오는 간선이 하나 생겼으므로 진입차수 1 증가

    result = []
    queue = deque()

    # 3. 처음 시작할 때, 진입차수가 0인(선행 조건이 없는) 모든 노드를 큐에 삽입
    for i in range(1, v + 1):
        if indegree[i] == 0:
            queue.append(i)

    # 4. 큐가 빌 때까지 반복
    while queue:
        # 큐에서 원소 꺼내기 (이 순서가 곧 위상 정렬 결과)
        now = queue.popleft()
        result.append(now)

        # 해당 원소와 연결된 노드들의 진입차수에서 1 빼기 (간선 제거 효과)
        for next_node in graph[now]:
            indegree[next_node] -= 1
            
            # 새롭게 진입차수가 0이 된 노드를 큐에 삽입
            if indegree[next_node] == 0:
                queue.append(next_node)

    # 5. 사이클 판별 (선택 사항이지만 알아두면 좋음)
    if len(result) != v:
        return "그래프에 사이클이 존재하여 위상 정렬이 불가능합니다."

    return result

# 사용 예시
if __name__ == "__main__":
    v = 6 # 노드 개수
    # [a, b]: a 작업을 해야 b 작업을 할 수 있음
    edges = [[1, 4], [2, 4], [3, 5], [4, 6], [5, 6]]
    
    # 올바른 순서 중 하나 출력
    print("위상 정렬 결과:", topological_sort(v, edges))
    # Output: 위상 정렬 결과: [1, 2, 3, 4, 5, 6] (1, 2, 3은 순서가 바뀌어도 무방함)