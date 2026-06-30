### 📌 BFS (Breadth-First Search / 너비 우선 탐색)

- **시간 복잡도 / Time Complexity**: $O(V + E)$ (인접 리스트 사용 시, $V$: 정점, $E$: 간선) / $O(V^2)$ (인접 행렬 사용 시)
- **공간 복잡도 / Space Complexity**: $O(V)$ (큐와 방문 처리 배열)
- **핵심 개념 / Core Concept**: 시작 정점으로부터 가까운 정점(동일한 깊이)을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 기법으로, 선입선출(FIFO) 구조인 큐(Queue)를 사용합니다. / A graph traversal algorithm that explores all nodes at the present depth level before moving on to the nodes at the next depth level, implemented using a Queue.
- **적용 상황 / When to Use**: 가중치가 없는 그래프에서의 최단 경로(Shortest Path) 찾기, 미로 탐색, 특정 거리 안의 노드 찾기, 웹 크롤링 등 시작점으로부터의 '단계(거리)'가 중요한 문제에 사용합니다. / Used for finding the shortest path in unweighted graphs, solving mazes, web crawling, and finding nodes within a certain distance from the source.