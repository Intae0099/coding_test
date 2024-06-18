import sys
# import copy

n, m = map(int, sys.stdin.readline().split())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
result = 0


def infection(x, y, infect_board):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if infect_board[nx][ny] == 0:
                infect_board[nx][ny] = 2
                infect_board = infection(nx, ny, infect_board)

    return infect_board


def count(result_board):
    temp = 0
    for i in result_board:
        temp += i.count(0)
    return temp


def dfs(x, y, cnt, temp_board):
    global result
    if cnt == 3:
        infect_board = [x[:] for x in temp_board]
        # infect_board = copy.deepcopy(temp_board)
        for i in range(n):
            for j in range(m):
                if infect_board[i][j] == 2:
                    infect_board = infection(i, j, infect_board)

        result = max(result, count(infect_board))


        return

    for i in range(n):
        for j in range(m):
            if temp_board[i][j] == 0:
                temp_board[i][j] = 1
                dfs(i, j, cnt + 1, temp_board)
                temp_board[i][j] = 0


dfs(0, 0, 0, board)
print(result)
