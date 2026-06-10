### 📌 Merge Sort (병합 정렬)

- **시간 복잡도 / Time Complexity**: 최선, 평균, 최악 모두 $O(N \log N)$
- **공간 복잡도 / Space Complexity**: $O(N)$ (병합을 위한 임시 배열 필요)
- **핵심 개념 / Core Concept**: 배열을 크기가 1이 될 때까지 반으로 나눈(Divide) 뒤, 다시 크기 순으로 정렬하며 합치는(Merge) 분할 정복(Divide and Conquer) 기반의 안정 정렬(Stable Sort)입니다. / A divide-and-conquer algorithm that recursively splits the array into halves until size 1, then merges the sorted halves. It is a stable sort.
- **적용 상황 / When to Use**: 데이터의 상태와 무관하게 항상 $O(N \log N)$의 성능 보장이 필요할 때, 동일한 값의 원래 순서가 유지되어야 하는 안정 정렬이 필요할 때, 또는 연결 리스트(Linked List)를 정렬할 때 사용합니다. / Used when strict $O(N \log N)$ performance is required regardless of initial data order, when stable sorting is necessary, or for sorting linked lists.