### 📌 DFS (Depth-First Search / 깊이 우선 탐색)

- **시간 복잡도 / Time Complexity**: $O(V + E)$ (인접 리스트 사용 시, $V$: 정점, $E$: 간선) / $O(V^2)$ (인접 행렬 사용 시)
- **공간 복잡도 / Space Complexity**: $O(V)$ (재귀 호출 스택 및 방문 처리 배열)
- **핵심 개념 / Core Concept**: 갈 수 있는 한 깊숙이 탐색을 진행하다가 더 이상 갈 곳이 없으면 가장 마지막에 만난 갈림길로 돌아와(Backtracking) 다른 방향을 탐색하는 알고리즘입니다. / A graph traversal algorithm that explores as far as possible along each branch before backtracking, typically implemented using recursion (or a stack).
- **적용 상황 / When to Use**: 모든 정점을 방문해야 할 때, 경로의 특징(예: 경로 상의 노드 합, 특정 조건)을 저장하며 탐색해야 할 때, 사이클(Cycle) 판별, 연결 요소(Connected Components)의 개수를 셀 때 사용합니다. / Used when searching the entire graph, finding paths with specific properties, cycle detection, and counting connected components.