# 1. 백트래킹을 이용한 정석 구현 (이진 트리 구조)
def generate_subsets(arr):
    result = []
    
    def backtrack(index, path):
        # 1. 종료 조건: 배열의 끝까지 모두 "넣을지 말지" 결정을 내렸다면 결과에 추가
        if index == len(arr):
            result.append(path[:])
            return
        
        # 2. 현재 원소를 '포함하는' 경우
        path.append(arr[index])
        backtrack(index + 1, path)
        path.pop() # 상태 복구
        
        # 3. 현재 원소를 '포함하지 않는' 경우
        backtrack(index + 1, path)
        
    backtrack(0, [])
    return result

# =====================================================================
# 2. 비트마스킹을 이용한 부분집합 (코딩 테스트 심화용)
# 원소의 포함 여부를 2진수의 0과 1로 표현하여 훨씬 빠르고 간결하게 구현합니다.
def generate_subsets_bitmask(arr):
    n = len(arr)
    result = []
    # 1 << n 은 2^n 을 의미합니다. (원소가 3개면 0부터 7까지)
    for i in range(1 << n):
        subset = []
        for j in range(n):
            # i의 j번째 비트가 1인지 확인 (1이면 해당 원소 포함)
            if i & (1 << j):
                subset.append(arr[j])
        result.append(subset)
    return result

# 사용 예시
if __name__ == "__main__":
    data = [1, 2, 3]
    
    print("백트래킹 부분집합:")
    for s in generate_subsets(data):
        print(s)
        
    print("\n비트마스킹 부분집합:")
    for s in generate_subsets_bitmask(data):
        print(s)