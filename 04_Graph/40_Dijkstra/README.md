### 📌 Dijkstra (다익스트라 최단 경로)

- **시간 복잡도 / Time Complexity**: $O((V + E) \log V)$ (우선순위 큐 사용 시, $V$: 정점, $E$: 간선)
- **공간 복잡도 / Space Complexity**: $O(V + E)$ (그래프 저장 및 우선순위 큐 메모리)
- **핵심 개념 / Core Concept**: 특정한 하나의 정점에서 출발하여 다른 모든 정점으로 가는 최단 경로를 구하는 알고리즘입니다. 매번 '가장 비용이 적게 드는 노드'를 선택(Greedy)하여 탐색하며, **음의 가중치를 가진 간선이 없을 때만** 정상 동작합니다. / An algorithm for finding the shortest paths between nodes in a graph. It uses a greedy approach and a Priority Queue (Min-Heap) to iteratively select the unvisited node with the lowest distance. It requires non-negative edge weights.
- **적용 상황 / When to Use**: 내비게이션(길 찾기), 네트워크 라우팅 등 가중치가 다른 여러 간선이 주어지고 특정 지점부터 다른 지점까지의 최소 비용을 구해야 할 때 사용합니다. / Used for GPS navigation, routing protocols (OSPF), and finding the minimum cost path in any graph with non-negative weights.