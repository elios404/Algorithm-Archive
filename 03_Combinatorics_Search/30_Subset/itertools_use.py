from itertools import combinations

def subsets_example():
    data = [1, 2, 3]
    
    print("itertools를 이용한 부분집합:")
    # 뽑는 개수(r)를 0부터 N까지 반복
    for r in range(len(data) + 1):
        for subset in combinations(data, r):
            # 출력: (), (1,), (2,), (3,), (1, 2) ... (1, 2, 3)
            print(list(subset)) 

if __name__ == "__main__":
    subsets_example()