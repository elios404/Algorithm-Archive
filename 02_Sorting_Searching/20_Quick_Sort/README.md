### 📌 Quick Sort (퀵 정렬)

- **시간 복잡도 / Time Complexity**: 평균(Average) $O(N \log N)$, 최악(Worst) $O(N^2)$ (이미 정렬된 경우)
- **공간 복잡도 / Space Complexity**: 평균 $O(\log N)$ (재귀 호출 스택), 최악 $O(N)$
- **핵심 개념 / Core Concept**: 기준이 되는 피벗(Pivot)을 하나 고른 뒤, 피벗보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할(Partition)하고 이를 재귀적으로 반복하는 제자리(In-place) 불안정 정렬(Unstable Sort)입니다. / A divide-and-conquer algorithm that partitions an array into two sub-arrays around a pivot element. It sorts in-place but is unstable.
- **적용 상황 / When to Use**: 추가적인 메모리 공간 할당(임시 배열 등)이 부담스럽고 평균적으로 가장 빠른 정렬 속도가 필요할 때 사용합니다. (단, 최악의 경우를 피하기 위해 실무에서는 피벗을 랜덤하게 고르거나, 삽입 정렬과 섞어 씁니다.) / Used when average-case sorting speed and low memory overhead are critical.