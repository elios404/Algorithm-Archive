def merge_sort(arr):
    """
    병합 정렬의 시작점. 임시 배열을 한 번만 할당하여 메모리 낭비를 막습니다.
    """
    temp = [0] * len(arr)
    _merge_sort_recursive(arr, temp, 0, len(arr) - 1)

def _merge_sort_recursive(arr, temp, left, right):
    if left < right:
        mid = (left + right) // 2
        
        # 1. 반으로 나누어 각각 정렬 (Divide)
        _merge_sort_recursive(arr, temp, left, mid)
        _merge_sort_recursive(arr, temp, mid + 1, right)
        
        # 2. 정렬된 두 부분 배열을 병합 (Merge)
        _merge(arr, temp, left, mid, right)

def _merge(arr, temp, left, mid, right):
    for i in range(left, right + 1):
        temp[i] = arr[i]
        
    i = left      # 왼쪽 부분 배열의 포인터
    j = mid + 1   # 오른쪽 부분 배열의 포인터
    k = left      # 원본 배열에 채워 넣을 위치 포인터

    # 두 배열을 비교하며 더 작은 값을 원본 배열에 복사
    while i <= mid and j <= right:
        if temp[i] <= temp[j]:  # <= 를 사용하여 안정 정렬(Stable Sort) 유지
            arr[k] = temp[i]
            i += 1
        else:
            arr[k] = temp[j]
            j += 1
        k += 1

    # 왼쪽 배열에 남은 원소들이 있다면 마저 복사
    # (오른쪽 배열은 이미 원본 배열의 끝자리에 있으므로 처리할 필요 없음)
    while i <= mid:
        arr[k] = temp[i]
        k += 1
        i += 1

# 사용 예시
if __name__ == "__main__":
    data = [38, 27, 43, 3, 9, 82, 10]
    print("정렬 전:", data)
    merge_sort(data)
    print("정렬 후:", data)