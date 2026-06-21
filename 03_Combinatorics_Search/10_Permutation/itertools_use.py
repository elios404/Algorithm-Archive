from itertools import permutations

def permutations_example():
    data = [1, 2, 3]
    
    # 1. 3개 중 2개를 뽑는 순열 생성
    # 반환값이 이터레이터(iterator)이므로 list()로 묶어주거나 바로 for문을 돌립니다.
    perm_iter = permutations(data, 2)
    
    print("itertools를 이용한 순열:")
    for p in perm_iter:
        print(p) # 튜플 형태로 출력됨: (1, 2), (1, 3), (2, 1) ...

    # [실전 꿀팁] 모든 원소를 다 뽑는 순열(N!)을 구하고 싶다면 r을 생략하면 됩니다.
    print("\n모든 원소를 뽑는 순열:")
    print(list(permutations(data)))

if __name__ == "__main__":
    permutations_example()