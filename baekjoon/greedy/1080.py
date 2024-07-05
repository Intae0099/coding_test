import sys

n, m = map(int, sys.stdin.readline().split())
board = []
goal_board = []
cnt = 0

for _ in range(n):
    board.append(list(map(int, sys.stdin.readline().strip())))

for _ in range(n):
    goal_board.append(list(map(int, sys.stdin.readline().strip())))

if n < 3 or m < 3:
    if board == goal_board:
        print(0)
    else:
        print(-1)
else:
    for i in range(n-2):
        for j in range(m-2):
            if board[i][j] != goal_board[i][j]:
                cnt += 1
                for p in range(i, i+3):
                    for q in range(j, j + 3):
                        if board[p][q] == 1:
                            board[p][q] = 0
                        elif board[p][q] == 0:
                            board[p][q] = 1

    if board != goal_board:
        print(-1)
    else:
        print(cnt)
