# 1. Union-Find 함수 정의
def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x]) # 경로 압축
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def kruskal(v, edges):
    """
    크루스칼 알고리즘 메인 뼈대
    """
    result_cost = 0 # 최소 신장 트리의 총 가중치 합
    parent = [i for i in range(v + 1)] # 부모 테이블 초기화

    # 1. 모든 간선을 가중치(비용) 순으로 오름차순 정렬
    # 간선 정보는 (비용, a, b) 형태로 들어있다고 가정
    edges.sort() 

    # 2. 정렬된 간선을 하나씩 확인
    for cost, a, b in edges:
        # 3. 사이클이 발생하지 않는 경우에만 집합에 포함 (부모가 다르면 사이클이 아님)
        if find(parent, a) != find(parent, b):
            union(parent, a, b) # 두 노드를 연결
            result_cost += cost # 총 비용에 추가

    return result_cost

# 사용 예시
if __name__ == "__main__":
    v = 7 # 노드의 개수
    # (비용, 노드 A, 노드 B)
    edges = [
        (29, 1, 2), (75, 1, 5),
        (35, 2, 3), (34, 2, 6),
        (7, 3, 4),
        (23, 4, 6), (13, 4, 7),
        (53, 5, 6),
        (25, 6, 7)
    ]
    
    total_cost = kruskal(v, edges)
    print(f"모든 노드를 연결하는 최소 비용: {total_cost}")