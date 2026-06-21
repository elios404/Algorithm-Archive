def generate_permutations(arr, r):
    """
    백트래킹을 이용하여 arr에서 r개를 뽑아 나열하는 모든 순열을 구합니다.
    """
    result = []
    visited = [False] * len(arr) # 각 원소의 사용 여부를 체크하는 배열
    
    def backtrack(path):
        # 1. 종료 조건: 원하는 개수(r)만큼 뽑았다면 결과에 추가하고 리턴
        if len(path) == r:
            result.append(path[:]) # path의 얕은 복사본을 넣어야 함에 주의!
            return
        
        # 2. 탐색: 배열의 처음부터 끝까지 확인
        for i in range(len(arr)):
            if not visited[i]:      # 아직 사용하지 않은 원소라면
                visited[i] = True   # 사용 처리 (방문 도장 쾅)
                path.append(arr[i]) # 경로에 추가
                
                backtrack(path)     # 다음 원소 뽑으러 재귀 호출 (깊이 파고들기)
                
                # 재귀가 끝나고 돌아오면 원래 상태로 복구 (백트래킹)
                path.pop()
                visited[i] = False
                
    backtrack([])
    return result

# 사용 예시
if __name__ == "__main__":
    data = [1, 2, 3]
    r = 2
    
    # 3개 중 2개를 뽑는 순열 (3P2 = 6개)
    print(f"{data}에서 {r}개를 뽑는 순열:")
    for p in generate_permutations(data, r):
        print(p)