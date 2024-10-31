from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
visited = [[False for _ in range(m)] for i in range(n)]
cnt = 0
max_area = 0
graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))


def bfs(x, y):
    global max_area
    area = 1
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if graph[ny][nx] and not visited[ny][nx]:
                    q.append((nx, ny))
                    visited[ny][nx] = True
                    area += 1

    max_area = max(max_area, area)


for i in range(m):
    for j in range(n):
        if graph[j][i] and not visited[j][i]:
            visited[j][i] = True
            cnt += 1
            bfs(i, j)

print(cnt)
print(max_area)
