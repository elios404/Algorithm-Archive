import sys
sys.setrecursionlimit(10**6) # 파이썬에서 재귀를 사용할 때 필수

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x]) # 경로 압축
    return parent[x]

def union(parent, a, b):
    root_a = find(parent, a)
    root_b = find(parent, b)
    if root_a < root_b: # 보통 번호가 더 작은 쪽을 부모로 삼는 단순한 규칙 사용
        parent[root_b] = root_a
    else:
        parent[root_a] = root_b

if __name__ == "__main__":
    v = 6 # 노드의 개수
    parent = [i for i in range(v)] # 초기화

    union(parent, 1, 2)
    union(parent, 2, 3)

    if find(parent, 1) == find(parent, 3):
        print("같은 집합입니다.")