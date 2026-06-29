def dfs(graph, v, visited, result):
    """
    재귀를 활용한 DFS 뼈대 코드
    """
    # 1. 현재 노드를 방문 처리하고 결과 리스트에 추가
    visited[v] = True
    result.append(v)
    
    # 2. 현재 노드와 연결된 다른 인접 노드들을 확인
    for next_node in graph[v]:
        # 3. 아직 방문하지 않은 노드라면 그 노드를 시작점으로 DFS 재귀 호출 (깊이 파고들기)
        if not visited[next_node]:
            dfs(graph, next_node, visited, result)

# 사용 예시
if __name__ == "__main__":
    n = 6 # 노드의 개수
    
    # 인접 리스트 (Adjacency List) 구성 
    # 인덱스를 노드 번호와 일치시키기 위해 0번 인덱스는 비워둡니다.
    graph = [
        [],
        [2, 3, 8], # 1번 노드와 연결된 노드들
        [1, 7],    # 2번 노드와 연결된 노드들
        [1, 4, 5], # 3번 노드와 연결된 노드들
        [3, 5],    # 4번 노드와 연결된 노드들
        [3, 4],    # 5번 노드와 연결된 노드들
        [7],       # 6번 노드와 연결된 노드들
        [2, 6],    # 7번 노드와 연결된 노드들
        [1]        # 8번 노드와 연결된 노드들
    ]
    
    visited = [False] * (len(graph)) # 방문 처리 리스트 초기화
    dfs_result = []
    
    # 1번 노드부터 DFS 탐색 시작
    dfs(graph, 1, visited, dfs_result)
    
    print("DFS 탐색 순서:", dfs_result)
    # Output: [1, 2, 7, 6, 3, 4, 5, 8]