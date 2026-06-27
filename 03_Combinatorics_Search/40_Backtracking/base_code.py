def solve_n_queens(n):
    """
    N-Queen 문제의 모든 해답을 찾는 백트래킹 뼈대
    """
    result = []
    # board[i] = j 는 "i번째 행의 j번째 열에 퀸이 있다"는 의미입니다.
    board = [-1] * n

    def is_valid(row, col):
        """
        현재 위치(row, col)에 퀸을 놓을 수 있는지 검사합니다. (가지치기 조건)
        """
        for i in range(row):
            # 1. 같은 열에 퀸이 있는지 확인 (board[i] == col)
            # 2. 대각선에 퀸이 있는지 확인 (행의 차이 == 열의 차이)
            if board[i] == col or abs(board[i] - col) == abs(i - row):
                return False
        return True

    def backtrack(row):
        # 1. 종료 조건: N개의 행에 모두 퀸을 무사히 배치했다면 정답 처리
        if row == n:
            result.append(board[:])
            return

        # 2. 탐색: 현재 행(row)의 0번 열부터 N-1번 열까지 퀸을 놓아봄
        for col in range(n):
            if is_valid(row, col): # ✨ 핵심: 유망한 자리인지(가지치기) 확인!
                board[row] = col   # 퀸을 놓음 (방문 처리)
                
                backtrack(row + 1) # 다음 행으로 넘어감 (재귀)
                
                board[row] = -1    # 퀸을 다시 뺌 (상태 복구 / 백트래킹)

    # 0번째 행부터 탐색 시작
    backtrack(0)
    return result

# 사용 예시
if __name__ == "__main__":
    n = 4
    solutions = solve_n_queens(n)
    
    print(f"{n}x{n} 체스판의 N-Queen 해답 개수: {len(solutions)}개")
    for idx, sol in enumerate(solutions, 1):
        print(f"해답 {idx}: {sol} (인덱스는 행, 값은 열을 의미)")