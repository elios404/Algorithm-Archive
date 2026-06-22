from itertools import combinations

def combinations_example():
    data = [1, 2, 3, 4]
    
    # 1. 4개 중 2개를 뽑는 조합 생성
    comb_iter = combinations(data, 2)
    
    print("itertools를 이용한 조합:")
    for c in comb_iter:
        print(c) # 튜플 형태로 출력됨: (1, 2), (1, 3), (1, 4), (2, 3) ...

if __name__ == "__main__":
    combinations_example()