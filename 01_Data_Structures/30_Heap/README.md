### 📌 Heap (힙)

- **시간복잡도 / Time Compelxity** : 삽입(Push) & 삭제(Pop): O(log N), 최솟값/최댓값 조회(Peek): O(1)
- **공간 복잡도 / Space Complexity** : O(N)
- **핵심 개념 / Core Concept** : 완전 이진 트리(Complete Binary Tree) 형태로, 부모 노드가 자식 노드보다 항상 작거나(최소 힙) 큰(최대 힙) 조건을 유지하여 우선순위를 관리하는 배열 기반 자료구조입니다. / A complete binary tree structure typically implemented via an array, maintaining the property where the parent node is always smaller(Min-Heap) or larger (Max-Heap) than its children.
- **적용 상황 / When to Use** : 데이터가 지속적으로 추가/삭제되는 환경에서 최댓값이나 최솟값을 빠르게 추적해야 할 때, 우선순위 큐(Priority Queue) 구현, 다익스트라(Dijkstra) 최단 경로 알고리즘, 상위 K개 데이터 추출 등에 사용합니다. / Used for fast retrieval of min/max values in dynamic datasets, implementing priority queues, Dijkstra's shortest path algorithm, and finding top K elements.