# 1. 정석적인 퀵 정렬 (In-place 정렬, 추가 메모리 최소화)
def quick_sort(arr):
    """퀵 정렬을 제어하는 메인 함수입니다."""
    _quick_sort(arr, 0, len(arr) - 1)

def _quick_sort(arr, low, high):
    if low < high:
        # 피벗을 기준으로 배열을 분할하고, 피벗의 최종 위치를 받습니다.
        pivot_index = _partition(arr, low, high)
        
        # 피벗을 제외한 왼쪽과 오른쪽 부분 배열을 재귀적으로 정렬합니다.
        _quick_sort(arr, low, pivot_index - 1)
        _quick_sort(arr, pivot_index + 1, high)

def _partition(arr, low, high):
    pivot = arr[high] # 가장 오른쪽 원소를 피벗으로 선택
    i = low - 1       # 피벗보다 작은 원소들이 들어갈 마지막 인덱스
    
    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i] # 작은 값을 왼쪽으로 스왑
            
    # 피벗을 최종 자기 자리(i + 1)로 이동시킵니다.
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1


# =====================================================================
# 2. 파이썬 특화 퀵 정렬 (코딩 테스트용)
# 리스트 컴프리헨션을 사용하여 직관적이고 짧지만, 새로운 리스트를 계속 만들어 메모리를 더 씁니다.
def quick_sort_pythonic(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[len(arr) // 2] # 가운데 원소를 피벗으로 설정
    left = [x for x in arr if x < pivot]
    mid = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    
    return quick_sort_pythonic(left) + mid + quick_sort_pythonic(right)


# 사용 예시
if __name__ == "__main__":
    data1 = [38, 27, 43, 3, 9, 82, 10]
    quick_sort(data1)
    print("정석 정렬 후:", data1)

    data2 = [38, 27, 43, 3, 9, 82, 10]
    print("파이썬 특화 정렬 후:", quick_sort_pythonic(data2))