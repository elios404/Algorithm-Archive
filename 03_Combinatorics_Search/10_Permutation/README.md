### 📌 Permutation (순열)

- **시간 복잡도 / Time Complexity**: $O(N!)$ (N개 중 N개를 뽑을 때) 또는 $O(_NP_R)$
- **공간 복잡도 / Space Complexity**: $O(R)$ (재귀 호출 스택 및 결과를 담을 배열의 크기)
- **핵심 개념 / Core Concept**: 서로 다른 $N$개의 원소 중에서 $R$개를 선택하여 **순서를 고려해** 나열하는 완전 탐색 기법입니다. (예: [A, B]와 [B, A]는 다름) / A method of arranging $R$ items out of $N$ distinct items where the **order of arrangement matters**. 
- **적용 상황 / When to Use**: 모든 가능한 순서나 배치를 확인해야 하는 완전 탐색 문제(외판원 순회 TSP, 줄 세우기, 비밀번호 조합 등)에 사용합니다. 단, $N$이 10~11을 넘어가면 시간 초과가 발생하므로 주의해야 합니다. / Used when evaluating all possible orderings is required (e.g., Traveling Salesperson Problem, arranging items). Only applicable for small $N$ ($N \le 10$) due to factorial time growth.