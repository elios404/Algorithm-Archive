def bellman_ford(start, v, edges):
    """
    음수 간선을 처리하고 음수 사이클을 판별하는 벨만-포드 알고리즘 뼈대
    """
    # 1. 최단 거리 테이블 초기화
    INF = float('inf')
    distance = [INF] * (v + 1)
    distance[start] = 0

    # 2. 전체 v - 1번의 라운드(반복)를 진행
    # (v개의 노드로 이루어진 그래프에서 최단 경로는 최대 v-1개의 간선을 가지기 때문)
    for i in range(v - 1):
        # 매 라운드마다 모든 간선을 확인
        for cur, next_node, weight in edges:
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
            # 단, 출발 노드가 한 번이라도 계산된 적이 있어야 함 (distance[cur] != INF)
            if distance[cur] != INF and distance[cur] + weight < distance[next_node]:
                distance[next_node] = distance[cur] + weight

    # 3. 음수 사이클 판별을 위해 마지막으로 1번 더(총 v번째) 모든 간선을 확인
    for cur, next_node, weight in edges:
        # 만약 v번째 라운드에서도 값이 갱신된다면, 무한히 작아지는 음수 사이클이 존재한다는 뜻
        if distance[cur] != INF and distance[cur] + weight < distance[next_node]:
            return None # 음수 사이클 존재 시 None 반환

    return distance

# 사용 예시
if __name__ == "__main__":
    v = 3 # 노드의 개수
    # edges 안의 원소: (출발 노드, 도착 노드, 가중치)
    edges = [
        (1, 2, 4),
        (1, 3, 3),
        (2, 3, -1), # 음수 가중치 간선
        (3, 1, -2)
    ]
    
    start_node = 1
    distances = bellman_ford(start_node, v, edges)
    
    if distances is None:
        print("그래프에 음수 사이클이 존재합니다.")
    else:
        print(f"{start_node}번 노드에서 출발하는 최단 거리:")
        for i in range(1, v + 1):
            if distances[i] == float('inf'):
                print(f"노드 {i}: 도달 불가")
            else:
                print(f"노드 {i}: {distances[i]}")