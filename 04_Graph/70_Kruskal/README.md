### 📌 Kruskal Algorithm (크루스칼 / 최소 신장 트리)

- **시간 복잡도 / Time Complexity**: $O(E \log E)$ ($E$: 간선. 간선을 정렬하는 데 걸리는 시간이 지배적임)
- **공간 복잡도 / Space Complexity**: $O(V)$ (Union-Find를 위한 parent 배열)
- **핵심 개념 / Core Concept**: 그래프 내의 모든 정점을 가장 적은 비용으로 연결하는 최소 신장 트리(Minimum Spanning Tree, MST)를 찾는 알고리즘입니다. 모든 간선을 가중치 기준 오름차순으로 정렬한 후, Union-Find를 이용해 사이클을 발생시키지 않는 간선만 선택하여 연결합니다. / A greedy algorithm that finds a Minimum Spanning Tree for a connected weighted graph. It sorts all edges by weight and adds them one by one to the growing spanning tree, unless adding an edge would form a cycle (checked via Union-Find).
- **적용 상황 / When to Use**: 여러 개의 도시나 노드가 있을 때, 모든 노드를 연결하는 최소 비용(예: 도로 건설, 통신망 구축, 전력망 연결)을 구할 때 사용합니다. / Used for network design (telecommunication, electrical, computer networks) to minimize the total length or cost of connections.