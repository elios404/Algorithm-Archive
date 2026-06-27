### 📌 Backtracking (백트래킹 / 되추적)

- **시간 복잡도 / Time Complexity**: 최악의 경우 $O(b^d)$ 또는 $O(N!)$ (단, 가지치기를 통해 실제 실행 시간은 훨씬 단축됨)
- **공간 복잡도 / Space Complexity**: $O(N)$ (재귀 호출의 깊이)
- **핵심 개념 / Core Concept**: 모든 경우의 수를 탐색하는 DFS(깊이 우선 탐색)를 기반으로 하되, 현재 탐색 중인 경로가 조건에 맞지 않으면(유망하지 않으면) 즉시 탐색을 멈추고 이전 단계로 돌아가 다른 경로를 탐색하는 **가지치기(Pruning)** 기법입니다. / An algorithmic technique for solving problems recursively by building a solution incrementally, and abandoning a path ("pruning") as soon as it determines that the path cannot possibly lead to a valid solution.
- **적용 상황 / When to Use**: N-Queen 문제, 스도쿠(Sudoku) 풀이, 미로 찾기, 단어 퍼즐 등 완전 탐색을 해야 하지만 $N$이 커서 불필요한 경로를 반드시 차단해야 시간 초과를 피할 수 있는 문제에 사용합니다. / Used in constraint satisfaction problems like N-Queens, Sudoku, and generating specific permutations where brute force is too slow and pruning invalid states early is required.