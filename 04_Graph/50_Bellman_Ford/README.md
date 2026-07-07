### 📌 Bellman-Ford (벨만-포드 최단 경로)

- **시간 복잡도 / Time Complexity**: $O(V \times E)$ ($V$: 정점, $E$: 간선)
- **공간 복잡도 / Space Complexity**: $O(V)$ (최단 거리 테이블)
- **핵심 개념 / Core Concept**: 특정 출발 노드에서 다른 모든 노드까지의 최단 거리를 구하는 알고리즘입니다. 매 반복마다 모든 간선을 확인하며 거리를 갱신(Relaxation)하기 때문에, 가중치가 음수인 간선이 있어도 정상 작동하며 $V$번째 반복에서도 값이 갱신된다면 '음수 사이클'이 존재함을 알 수 있습니다. / An algorithm that computes shortest paths from a single source vertex to all of the other vertices in a weighted digraph. It is slower than Dijkstra's but is capable of handling graphs with negative edge weights and detecting negative weight cycles.
- **적용 상황 / When to Use**: 간선의 비용이 음수(예: 시간이 거꾸로 흐르는 웜홀, 타임머신 문제 등)가 포함된 상태에서 최단 거리를 구하거나, 그래프 내에 무한히 이득을 보는 음수 순환이 존재하는지 파악해야 할 때 사용합니다. / Used when the graph contains negative weight edges or when detecting negative cycles (e.g., arbitrage in currency exchange) is required.