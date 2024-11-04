from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

graph = []
for _ in range(m):
    graph.append(list(map(int, sys.stdin.readline().split())))


def bfs(q_list):
    q = deque(q_list)
    time = 0
    temp = []
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
                graph[nx][ny] = 1
                temp.append((nx, ny))
        if len(q) == 0 and temp:
            q = deque(temp)
            temp = []
            time += 1

    return time


start = []

for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            start.append((i, j))


result = bfs(start)
for i in graph:
    if 0 in i:
        print(-1)
        break
else:
    print(result)
