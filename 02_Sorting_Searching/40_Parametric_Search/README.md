### 📌 Parametric Search (매개변수 탐색)

- **시간 복잡도 / Time Complexity**: $O(T \log (\text{Range}))$ (단, $T$는 조건을 검사하는 데 걸리는 시간)
- **공간 복잡도 / Space Complexity**: $O(1)$ (검사 로직에 따라 다를 수 있음)
- **핵심 개념 / Core Concept**: 최적화 문제(최댓값/최솟값 찾기)를 결정 문제(Yes/No)로 바꾸어 이분 탐색을 통해 정답의 범위를 좁혀나가는 기법입니다. / A search technique that converts an optimization problem into a decision problem (Yes/No), using binary search to narrow down the range of possible answers.
- **적용 상황 / When to Use**: "조건을 만족하는 가능한 한 가장 큰(또는 작은) 값은?" 형태의 문제, 구해야 하는 정답의 범위가 비정상적으로 클 때(예: 10억 이상) 사용합니다. (예: 랜선 자르기, 예산 분배, 공유기 설치 등) / Used when the search range is massive and the problem asks for a maximum/minimum value that satisfies a specific condition (e.g., cutting cables, allocating budgets).