# 문제의 조건을 잘 읽어보고 수행하기
import sys

n, m = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())

board = []
for _ in range(n):
    board.append(list(map(int, sys.stdin.readline().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def check(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] == 0:
                return True
    return False

def front_move(x, y, dire):
    for i in range(4):
        dire = (dire+3) % 4
        nx = x + dx[dire]
        ny = y + dy[dire]
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] == 0:
                return nx, ny, dire


def back_move(x, y, dire):
    nx = x - dx[dire]
    ny = y - dy[dire]
    if 0 <= nx < n and 0 <= ny < m:
        if board[nx][ny] != 1:
            return nx, ny

    return -1, -1


board[r][c] = 2
cnt = 1

while True:
    if board[r][c] == 0:
        board[r][c] = 2
        cnt += 1

    if check(r, c):
        r, c, d = front_move(r, c, d)
    else:
        r, c = back_move(r, c, d)

    if r == c == -1:
        break

print(cnt)
