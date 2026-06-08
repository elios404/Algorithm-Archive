class UnionFind:
    def __init__(self, size):
        # 처음에는 각 노드가 자기 자신을 부모로 가리키도록 초기화
        self.parent = [i for i in range(size)]
        # 트리의 깊이(Rank)를 저장하여 병합 시 최적화에 사용
        self.rank = [0] * size

    def find(self, x):
        """특정 원소가 속한 집합의 루트 노드를 찾습니다. (경로 압축 적용)"""
        if self.parent[x] != x:
            # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀 호출하며 부모를 갱신 (Path Compression)
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, a, b):
        """두 원소가 속한 집합을 하나로 합칩니다. (Union by Rank 적용)"""
        root_a = self.find(a)
        root_b = self.find(b)

        if root_a != root_b:
            # 깊이(rank)가 더 낮은 트리를 깊이가 높은 트리 밑에 붙여서 전체 깊이 증가를 방지
            if self.rank[root_a] > self.rank[root_b]:
                self.parent[root_b] = root_a
            elif self.rank[root_a] < self.rank[root_b]:
                self.parent[root_a] = root_b
            else:
                self.parent[root_b] = root_a
                self.rank[root_a] += 1

    def is_connected(self, a, b):
        """두 원소가 같은 집합에 속해 있는지 확인합니다."""
        return self.find(a) == self.find(b)


# 사용 예시
if __name__ == "__main__":
    uf = UnionFind(6) # 0부터 5까지의 노드 생성
    uf.union(1, 2)
    uf.union(2, 3)
    uf.union(4, 5)

    print(uf.is_connected(1, 3)) # Output: True (1-2-3 연결됨)
    print(uf.is_connected(1, 5)) # Output: False (연결 안 됨)