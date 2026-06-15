def check(mid, data, target):
    """
    결정 함수 (Decision Function)
    mid(현재 탐색 중인 정답 후보)가 조건을 만족하는지(Yes/No) 검사합니다.
    """
    count = 0
    for length in data:
        count += length // mid # 각 랜선을 mid 길이로 잘랐을 때 나오는 개수
    return count >= target # 목표 개수(target) 이상을 만들 수 있으면 True

def parametric_search(data, target):
    """
    최대 길이를 찾는 매개변수 탐색 메인 로직
    """
    # 1. 정답이 될 수 있는 최소 범위와 최대 범위를 설정합니다.
    low = 1 
    high = max(data)
    result = 0 # 조건을 만족하는 최댓값을 저장할 변수

    # 2. 이분 탐색 시작
    while low <= high:
        mid = low + (high - low) // 2

        # 3. mid 값이 조건을 만족하는지 확인
        if check(mid, data, target):
            result = mid      # 조건을 만족하므로 일단 정답으로 저장
            low = mid + 1     # "더 긴 길이(최댓값)"도 가능한지 확인하기 위해 범위를 오른쪽으로 좁힘
        else:
            high = mid - 1    # 조건을 만족하지 못했으므로 길이를 줄이기 위해 범위를 왼쪽으로 좁힘

    return result

# 사용 예시
if __name__ == "__main__":
    # 가지고 있는 랜선들의 길이 (data)와 만들어야 하는 랜선의 개수 (target)
    cables = [802, 743, 457, 539]
    needed_cables = 11
    
    max_length = parametric_search(cables, needed_cables)
    print(f"조건을 만족하는 최대 랜선 길이: {max_length}") # Output: 200