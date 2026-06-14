def binary_search(arr, target):
    """
    반복문을 이용한 이분 탐색 정석 구현 (배열은 반드시 정렬되어 있어야 함)
    """
    low = 0
    high = len(arr) - 1

    while low <= high:
        # (low + high) // 2 도 가능하지만, 
        # 다른 언어에서의 오버플로우를 방지하는 습관인 low + (high - low) // 2 도 좋습니다.
        mid = (low + high) // 2 

        if arr[mid] == target:
            return mid       # 타겟을 찾은 경우 인덱스 반환
        elif arr[mid] > target:
            high = mid - 1   # 타겟이 중간값보다 작으면 왼쪽 구간 탐색
        else:
            low = mid + 1    # 타겟이 중간값보다 크면 오른쪽 구간 탐색

    return -1 # 탐색 실패 시 -1 반환


# 사용 예시
if __name__ == "__main__":
    # 데이터는 정렬되어 있다고 가정
    data = [2, 4, 6, 8, 10, 12, 14, 16]
    target_val = 10
    
    result = binary_search(data, target_val)
    if result != -1:
        print(f"Target {target_val} is at index: {result}")
    else:
        print("Target not found.")