from collections import deque
import sys

n = int(sys.stdin.readline())
board = []
shark_size = 2

x, y = 0, 0
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

fish_dict = {}

for i in range(n):
    temp_list = list(map(int, sys.stdin.readline().split()))
    if 9 in temp_list:
        x, y = i, temp_list.index(9)

    for j in range(n):
        if temp_list[j] != 0 and temp_list[j] != 9:
            if temp_list[j] not in fish_dict:
                fish_dict[temp_list[j]] = [(i, j)]
            else:
                fish_dict[temp_list[j]].append((i, j))

    board.append(temp_list)

board[x][y] = 0


def bfs(x, y):
    q = deque()
    q.append((x, y))
    dis_board = [[0] * n for _ in range(n)]
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] <= shark_size and dis_board[nx][ny] == 0:
                    dis_board[nx][ny] = dis_board[x][y] + 1
                    q.append((nx, ny))

    return dis_board


def check_min_dis(temp_board):
    eat_list = []
    min_dis = 1e9
    result_x, result_y = 0, 0
    for i in range(1, shark_size):
        if i in fish_dict:
            eat_list += fish_dict[i]

    if not eat_list:
        return -1, -1, -1

    eat_list.sort(key=lambda x:(x[0], x[1]))
    for x, y in eat_list:
        if min_dis > temp_board[x][y]:
            if temp_board[x][y] != 0:
                min_dis = temp_board[x][y]
                result_x, result_y = x, y

    fish_size = board[result_x][result_y]
    board[result_x][result_y] = 0
    if min_dis == 1e9:
        return -1, -1, -1


    if len(fish_dict[fish_size]) > 1:
        fish_dict[fish_size].remove((result_x, result_y))
    else:
        del fish_dict[fish_size]

    return result_x, result_y, min_dis


def solution(x, y):
    global shark_size
    time = 0
    shark_eat_cnt = 0
    while True:
        if len(fish_dict.keys()) < 1:
            return time

        if shark_size <= min(fish_dict.keys()):
            return time

        dis_board = bfs(x, y)
        x, y, temp_time = check_min_dis(dis_board)

        if x == y == -1:
            return time
        else:
            shark_eat_cnt += 1
            if shark_eat_cnt == shark_size:
                shark_eat_cnt = 0
                shark_size += 1

        time += temp_time

print(solution(x, y))
