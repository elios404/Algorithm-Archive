### 📌 Subset (부분집합 / Power Set)

- **시간 복잡도 / Time Complexity**: $O(2^N)$ (각 원소마다 포함/미포함 2가지 경우의 수)
- **공간 복잡도 / Space Complexity**: $O(N)$ (재귀 호출 스택)
- **핵심 개념 / Core Concept**: 주어진 집합의 모든 가능한 부분집합(멱집합, Power Set)을 구하는 기법으로, 각 원소가 '포함된다(True)'와 '포함되지 않는다(False)'의 상태를 가지는 이진 트리 형태의 탐색입니다. / A technique to generate all possible subsets (the power set) of a given set, functioning as a binary decision tree where each element is either 'included' or 'excluded'.
- **적용 상황 / When to Use**: 0-1 배낭 문제(Knapsack)의 완전 탐색, 모든 가능한 조합의 경우의 수를 확인해야 할 때, 비트 연산(Bitmasking)을 통한 상태 관리에 사용합니다. / Used when checking all possible combinations of any size is necessary, brute-forcing the 0-1 Knapsack problem, or utilizing bitmasking to represent states.