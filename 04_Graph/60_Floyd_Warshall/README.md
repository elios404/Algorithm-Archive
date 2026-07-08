### 📌 Floyd-Warshall (플로이드-워셜 최단 경로)

- **시간 복잡도 / Time Complexity**: $O(V^3)$ ($V$: 정점)
- **공간 복잡도 / Space Complexity**: $O(V^2)$ (2차원 인접 행렬 테이블)
- **핵심 개념 / Core Concept**: 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구하는 알고리즘입니다. 2차원 배열에 최단 거리 정보를 저장하며, 다이나믹 프로그래밍 점화식인 $D_{ab} = \min(D_{ab}, D_{ak} + D_{kb})$ (a에서 b로 가는 최소 비용과 a에서 k를 거쳐 b로 가는 비용 중 작은 값)을 사용하여 3중 반복문으로 갱신합니다. / An algorithm for finding shortest paths in a directed weighted graph with positive or negative edge weights (but with no negative cycles) between all pairs of vertices. It uses a dynamic programming approach.
- **적용 상황 / When to Use**: 출발지가 하나로 정해져 있지 않고 모든 노드 간의 최단 거리가 다 필요할 때 사용합니다. 시간 복잡도가 매우 크므로 보통 정점의 개수가 500개 이하인 문제에서만 출제됩니다. / Used when the all-pairs shortest paths are required. Due to its cubic time complexity, it is only practical for small graphs ($V \le 500$).