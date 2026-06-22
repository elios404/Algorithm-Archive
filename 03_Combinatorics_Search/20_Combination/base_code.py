def generate_combinations(arr, r):
    """
    백트래킹을 이용하여 arr에서 순서에 상관없이 r개를 뽑는 모든 조합을 구합니다.
    """
    result = []
    
    # start: 이번 재귀에서 탐색을 시작할 인덱스 (이전 원소는 쳐다보지 않음)
    def backtrack(start, path):
        # 1. 종료 조건: 원하는 개수(r)만큼 뽑았다면 결과에 추가
        if len(path) == r:
            result.append(path[:])
            return
        
        # 2. 탐색: start 인덱스부터 배열의 끝까지 확인
        for i in range(start, len(arr)):
            path.append(arr[i])         # 현재 원소를 뽑음
            
            # 다음 원소는 현재 뽑은 원소의 '다음 인덱스(i + 1)'부터 탐색하도록 넘김
            backtrack(i + 1, path)      
            
            # 원래 상태로 복구 (백트래킹)
            path.pop()                  
                
    backtrack(0, [])
    return result

# 사용 예시
if __name__ == "__main__":
    data = [1, 2, 3, 4]
    r = 2
    
    # 4개 중 2개를 뽑는 조합 (4C2 = 6개)
    print(f"{data}에서 {r}개를 뽑는 조합:")
    for c in generate_combinations(data, r):
        print(c)