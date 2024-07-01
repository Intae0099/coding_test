import sys
from collections import deque


dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

n = int(sys.stdin.readline())

board = [[0] * n for _ in range(n)]

k = int(sys.stdin.readline())
for _ in range(k):
    x, y = map(int, sys.stdin.readline().split())
    # 1은 사과 2는 뱀
    board[x-1][y-1] = 1


l = int(sys.stdin.readline())
l_dict = {}
for _ in range(l):
    x, y = sys.stdin.readline().split()
    l_dict[int(x)] = y


def bfs(x, y, time, dire):
    q = deque()
    q.append((x, y))
    board[x][y] = 2
    while q:
        x, y = q[0][0], q[0][1]

        time += 1

        nx = x + dx[dire]
        ny = y + dy[dire]

        if time in l_dict:
            if l_dict[time] == 'D':
                dire = (dire + 1) % 4
            else:
                dire = (dire - 1) % 4

        if dire > 3:
            dire = 0
        elif dire < 0:
            dire = 3

        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] != 2:
                q.appendleft((nx, ny))
                if board[nx][ny] == 1: #꼬리 방치해서 늘리기
                    board[nx][ny] = 2
                    continue
                else:
                    board[nx][ny] = 2
                    temp_x, temp_y = q.pop() #꼬리 한칸 말기
                    board[temp_x][temp_y] = 0

            else:
                #자기 꼬리에 부딛히면
                return time
        else:
            # 벽에 부딛히면
            return time


print(bfs(0, 0, 0, 0))
