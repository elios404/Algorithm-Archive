import heapq

def dijkstra(start, graph, v):
    """
    우선순위 큐를 활용한 다익스트라 알고리즘 뼈대
    """
    # 1. 최단 거리 테이블 초기화 (무한대로 설정)
    INF = float('inf')
    distance = [INF] * (v + 1)
    
    # 2. 우선순위 큐 생성 및 시작 노드 설정
    q = []
    # heapq는 튜플의 첫 번째 값을 기준으로 정렬하므로 (거리, 노드 번호) 순으로 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        
        # 3. 현재 노드가 이미 처리된 적이 있는 노드라면 무시 (가지치기)
        if distance[now] < dist:
            continue
            
        # 4. 현재 노드와 연결된 다른 인접한 노드들을 확인
        for next_node, weight in graph[now]:
            cost = dist + weight # 거쳐서 가는 비용 계산
            
            # 5. 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))
                
    return distance

# 사용 예시
if __name__ == "__main__":
    v = 6 # 노드의 개수
    # graph[i] = (인접 노드, 가중치) 
    graph = [
        [],
        [(2, 2), (3, 5), (4, 1)], # 1번 노드에서 2번(비용 2), 3번(비용 5), 4번(비용 1)으로 감
        [(3, 3), (4, 2)],
        [(2, 3), (6, 5)],
        [(3, 3), (5, 1)],
        [(3, 1), (6, 2)],
        []
    ]
    
    start_node = 1
    distances = dijkstra(start_node, graph, v)
    
    print(f"{start_node}번 노드에서 출발하는 최단 거리:")
    for i in range(1, v + 1):
        if distances[i] == float('inf'):
            print(f"노드 {i}: 도달 불가")
        else:
            print(f"노드 {i}: {distances[i]}")