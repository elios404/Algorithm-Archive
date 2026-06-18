def sliding_window_max_sum(arr, k):
    """
    크기가 K인 연속된 부분 배열 중 가장 큰 합을 반환하는 슬라이딩 윈도우 템플릿
    """
    n = len(arr)
    
    # 예외 처리: 배열의 길이가 창문 크기보다 작으면 계산 불가
    if n < k:
        return None 
    
    # 1. 첫 번째 창문(인덱스 0부터 k-1까지)의 합을 먼저 구합니다.
    window_sum = sum(arr[:k])
    max_sum = window_sum
    
    # 2. 창문을 한 칸씩 오른쪽으로 밀면서 최대 합을 갱신합니다.
    for i in range(k, n):
        # 핵심 로직: 새로 들어온 값은 더하고, 창문을 벗어난 맨 앞의 값은 뺍니다.
        window_sum += arr[i] - arr[i - k]
        
        if window_sum > max_sum:
            max_sum = window_sum
            
    return max_sum

# 사용 예시
if __name__ == "__main__":
    data = [2, 1, 5, 1, 3, 2]
    window_size = 3
    
    result = sliding_window_max_sum(data, window_size)
    print(f"크기가 {window_size}인 부분 배열의 최대 합: {result}") # Output: 9 (5 + 1 + 3)