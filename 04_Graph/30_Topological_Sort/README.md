### 📌 Topological Sorting (위상 정렬)

- **시간 복잡도 / Time Complexity**: $O(V + E)$ ($V$: 정점, $E$: 간선)
- **공간 복잡도 / Space Complexity**: $O(V)$ (진입차수 배열 및 큐)
- **핵심 개념 / Core Concept**: 순환(Cycle)이 없는 방향 그래프(DAG, Directed Acyclic Graph)에서, 방향성에 거스르지 않도록 모든 정점을 선형으로 나열하는 알고리즘입니다. 핵심은 자신에게 들어오는 간선의 개수인 **진입차수(In-degree)**가 0인 노드부터 큐에 넣어 차례대로 지워나가는 것입니다. / A linear ordering of its vertices such that for every directed edge $u \to v$, vertex $u$ comes before $v$ in the ordering. It only works on Directed Acyclic Graphs (DAGs).
- **적용 상황 / When to Use**: 선수 과목 수강 순서 결정, 작업 스케줄링, 빌드 시스템(Make, Gradle) 등 작업 간의 의존성(Dependency)이 존재할 때 순서를 정하기 위해 사용합니다. / Used for scheduling tasks with dependencies, resolving prerequisites, and build systems.