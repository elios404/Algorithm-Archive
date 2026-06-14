### 📌 Binary Search (이분 탐색)

- **시간 복잡도 / Time Complexity**: $O(\log N)$
- **공간 복잡도 / Space Complexity**: $O(1)$ (반복문 구현 시) / $O(\log N)$ (재귀 구현 시)
- **핵심 개념 / Core Concept**: **반드시 정렬된 배열**에서 탐색 범위를 절반씩 줄여가며 타겟 값을 찾는 알고리즘입니다. / A search algorithm that finds the position of a target value within a **sorted array** by repeatedly dividing the search interval in half.
- **적용 상황 / When to Use**: 정렬된 데이터에서 특정 값을 매우 빠르게 찾아야 할 때, 특정 값이 들어갈 위치나 경계값(Lower/Upper Bound)을 찾을 때, 최적화 문제를 결정 문제로 바꾸어 푸는 매개변수 탐색(Parametric Search)의 뼈대로 사용합니다. / Used for extremely fast lookups in sorted data, finding insertion points or boundaries, and serving as the foundation for parametric search.