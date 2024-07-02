import sys

n = int(sys.stdin.readline())
board = []
for _ in range(n):
    board.append(list(sys.stdin.readline().strip()))

result = 0

def check(temp_board):
    global result

    # 행/열 계산
    for i in range(n):
        x_cnt = 1
        y_cnt = 1
        for j in range(1, n):
            if temp_board[i][j] == temp_board[i][j-1]:
                x_cnt += 1
            else:
                if x_cnt > result:
                    result = x_cnt
                x_cnt = 1

            if temp_board[j][i] == temp_board[j-1][i]:
                y_cnt += 1
            else:
                if y_cnt > result:
                    result = y_cnt
                y_cnt = 1

        if x_cnt > result:
            result = x_cnt

        if y_cnt > result:
            result = y_cnt


check(board)

for i in range(n):
    for j in range(1, n):
        #열
        if board[i][j] != board[i][j-1]:
            board[i][j], board[i][j-1] = board[i][j-1], board[i][j]
            check(board)
            board[i][j], board[i][j-1] = board[i][j-1], board[i][j]

        #행
        if board[j][i] != board[j-1][i]:
            board[j][i], board[j-1][i] = board[j-1][i], board[j][i]
            check(board)
            board[j][i], board[j-1][i] = board[j-1][i], board[j][i]

print(result)
