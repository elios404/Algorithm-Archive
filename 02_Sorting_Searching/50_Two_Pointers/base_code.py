def two_pointers_pair_sum(arr, target):
    """
    정렬된 배열에서 두 수의 합이 target이 되는 쌍을 찾는 투 포인터 기본 뼈대
    주의: 이 방식을 사용하려면 배열이 반드시 '정렬'되어 있어야 합니다.
    """
    left = 0
    right = len(arr) - 1

    while left < right:
        current_sum = arr[left] + arr[right]

        if current_sum == target:
            return (arr[left], arr[right]) # 정답을 찾은 경우 튜플로 반환
        elif current_sum < target:
            left += 1  # 합이 타겟보다 작으면, 값을 키우기 위해 왼쪽 포인터를 우측으로 이동
        else:
            right -= 1 # 합이 타겟보다 크면, 값을 줄이기 위해 오른쪽 포인터를 좌측으로 이동

    return None # 조건을 만족하는 쌍이 없는 경우

# 사용 예시
if __name__ == "__main__":
    # 데이터는 정렬되어 있다고 가정 (정렬 안 되어있으면 arr.sort() 먼저 실행)
    data = [2, 3, 5, 7, 11, 15]
    target_val = 12
    
    result = two_pointers_pair_sum(data, target_val)
    if result:
        print(f"합이 {target_val}이 되는 두 수: {result}") # Output: (5, 7)
    else:
        print("조건을 만족하는 쌍이 없습니다.")