### 📌 Union-Find (Disjoint Set / 서로소 집합)

- **시간 복잡도 / Time Complexity**: Find & Union: $O(\alpha(N))$ (경로 압축 적용 시 상수 시간에 수렴)
- **공간 복잡도 / Space Complexity**: $O(N)$
- **핵심 개념 / Core Concept**: 여러 노드가 존재할 때, 두 노드가 같은 그래프(집합)에 속하는지 판별(Find)하고 병합(Union)하는 트리 기반 알고리즘입니다. 최적화를 위해 경로 압축(Path Compression)과 랭크 기반 병합(Union by Rank)을 사용합니다. / A data structure that tracks elements partitioned into disjoint subsets. It relies on two heavily optimized operations: Find (with path compression) and Union (by rank/size).
- **적용 상황 / When to Use**: 크루스칼 알고리즘(Kruskal's MST), 무방향 그래프의 사이클 판별, 네트워크 연결 상태 파악, 이미지 세그멘테이션(Connected Components)에 사용합니다. / Used for cycle detection in undirected graphs, Kruskal's Minimum Spanning Tree algorithm, and grouping connected components.