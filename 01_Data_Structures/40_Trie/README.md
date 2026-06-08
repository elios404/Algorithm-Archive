### 📌 Trie (트라이 / prefix tree)

- **시간 복잡도 / Time Complexity**: 삽입(Insert) & 탐색(Search): $O(L)$ (단, $L$은 문자열의 길이)
- **공간 복잡도 / Space Complexity**: $O(N \times L \times \text{Alphabet Size})$ (최악의 경우, 모든 문자열이 접두사를 공유하지 않을 때)
- **핵심 개념 / Core Concept**: 문자열의 접두사(Prefix)를 노드로 공유하여 트리 형태로 저장하는 자료구조로, N개의 문자열 중 특정 문자열을 길이만큼의 시간만 들여 빠르게 찾을 수 있습니다. / A tree-like data structure that stores a dynamic set of strings, where keys are usually strings. It optimizes prefix-based searches by sharing common prefixes among words.
- **적용 상황 / When to Use**: 자동 완성(Autocomplete), 검색어 추천, 사전 단어 찾기, 맞춤법 검사기, 라우팅 테이블(가장 긴 접두사 매칭) 등 다수의 문자열 데이터를 다룰 때 사용합니다. / Used for implementing autocomplete features, spell checkers, dictionary word lookups, and IP routing (longest prefix match).