from bisect import bisect_left, bisect_right

def bisect_example():
    # 데이터는 반드시 정렬되어 있어야 합니다.
    arr = [1, 2, 4, 4, 4, 6, 8]

    # 1. bisect_left(arr, x): x가 들어갈 수 있는 가장 왼쪽 인덱스 (Lower Bound)
    # x와 동일한 값이 배열에 있으면 그 값의 첫 번째 위치를 반환
    left_index = bisect_left(arr, 4)
    print("Lower Bound of 4:", left_index) # Output: 2

    # 2. bisect_right(arr, x): x가 들어갈 수 있는 가장 오른쪽 인덱스 (Upper Bound)
    # x와 동일한 값이 배열에 있으면 그 값들의 바로 다음 위치를 반환
    right_index = bisect_right(arr, 4)
    print("Upper Bound of 4:", right_index) # Output: 5

    # [실전 꿀팁] 특정 범위 [left_val, right_val] 안에 있는 데이터의 개수 구하기
    # 4가 몇 개 있는지 계산: right_index(5) - left_index(2) = 3개
    count = right_index - left_index
    print("Count of 4:", count) # Output: 3

if __name__ == "__main__":
    bisect_example()