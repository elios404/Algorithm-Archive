### 📌 Combination (조합)

- **시간 복잡도 / Time Complexity**: $O(_{N}C_{R})$ (N개 중 R개를 뽑는 경우의 수)
- **공간 복잡도 / Space Complexity**: $O(R)$ (재귀 호출 스택 및 결과를 담을 배열의 크기)
- **핵심 개념 / Core Concept**: 서로 다른 $N$개의 원소 중에서 $R$개를 선택할 때, **순서를 고려하지 않고** 뽑는 완전 탐색 기법입니다. (예: [A, B]와 [B, A]는 같은 것으로 취급) / A method of selecting $R$ items out of $N$ distinct items where the **order of selection does not matter**.
- **적용 상황 / When to Use**: 팀 나누기, 로또 번호 생성, 대표 뽑기 등 순서와 상관없이 특정 개수의 원소를 선택해야 하는 모든 경우에 사용합니다. / Used when evaluating combinations of items where order is irrelevant (e.g., forming teams, selecting subsets of a fixed size).