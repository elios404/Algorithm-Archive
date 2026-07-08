def floyd_warshall(v, edges):
    """
    모든 노드에서 모든 노드로 가는 최단 거리를 구하는 플로이드-워셜 뼈대
    """
    INF = float('inf')
    # 1. 2차원 최단 거리 테이블 초기화
    graph = [[INF] * (v + 1) for _ in range(v + 1)]

    # 2. 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for a in range(1, v + 1):
        graph[a][a] = 0

    # 3. 간선 정보 입력 (a에서 b로 가는 비용은 c)
    for a, b, c in edges:
        graph[a][b] = c

    # 4. 점화식에 따라 플로이드-워셜 알고리즘 수행 (핵심 3중 루프)
    for k in range(1, v + 1):           # k: 거쳐가는 노드
        for i in range(1, v + 1):       # i: 출발 노드
            for j in range(1, v + 1):   # j: 도착 노드
                # i에서 j로 바로 가는 것보다 k를 거쳐서 가는 것이 더 저렴한지 확인
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    return graph

# 사용 예시
if __name__ == "__main__":
    v = 4 # 노드의 개수
    # [출발, 도착, 비용]
    edges = [
        [1, 2, 4],
        [1, 4, 6],
        [2, 1, 3],
        [2, 3, 7],
        [3, 1, 5],
        [3, 4, 4],
        [4, 3, 2]
    ]

    result_graph = floyd_warshall(v, edges)

    print("모든 쌍의 최단 거리 결과:")
    for a in range(1, v + 1):
        for b in range(1, v + 1):
            if result_graph[a][b] == float('inf'):
                print("INF", end=" ")
            else:
                print(result_graph[a][b], end=" ")
        print()