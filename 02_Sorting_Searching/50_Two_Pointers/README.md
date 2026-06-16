### 📌 Two Pointers (투 포인터)

- **시간 복잡도 / Time Complexity**: $O(N)$ (단, 정렬이 필요할 경우 정렬 시간 $O(N \log N)$ 추가)
- **공간 복잡도 / Space Complexity**: $O(1)$
- **핵심 개념 / Core Concept**: 1차원 배열에서 두 개의 포인터(인덱스)를 조작하여 원하는 결과를 얻는 최적화 기법으로, 보통 완전 탐색($O(N^2)$)을 선형 시간($O(N)$)으로 줄여줍니다. / An optimization technique using two pointers (indices) to iterate through a linear data structure, effectively reducing $O(N^2)$ nested loops to an $O(N)$ linear scan.
- **적용 상황 / When to Use**: 정렬된 배열에서 특정한 합을 가지는 두 수 찾기, 팰린드롬(회문) 판별, 연속된 부분 배열의 합 구하기, 두 정렬된 배열의 병합 시 사용합니다. / Used for finding pairs with a specific sum in a sorted array, checking palindromes, finding contiguous subarray sums, and merging sorted arrays.