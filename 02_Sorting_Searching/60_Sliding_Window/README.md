### 📌 Sliding Window (슬라이딩 윈도우)

- **시간 복잡도 / Time Complexity**: $O(N)$
- **공간 복잡도 / Space Complexity**: $O(1)$
- **핵심 개념 / Core Concept**: 1차원 배열에서 특정 크기의 '창문(Window)'을 이동시키며, 매번 구간을 처음부터 새로 계산하지 않고 **빠지는 앞쪽 값은 빼고 새로 들어오는 뒤쪽 값만 더하여** 상태를 갱신하는 최적화 기법입니다. / An optimization technique that slides a "window" over a data structure, updating the result by only calculating the difference (subtracting the outgoing element and adding the incoming one) to avoid redundant loops.
- **적용 상황 / When to Use**: 고정된 길이 $K$의 연속된 부분 배열의 최대/최소 합 구하기, 특정 조건을 만족하는 가장 긴/짧은 부분 문자열 찾기, 네트워크 패킷 버퍼 처리 등에 사용합니다. / Used for finding the max/min sum of a contiguous subarray of a fixed size, or finding the longest/shortest substring/subarray that meets specific conditions.