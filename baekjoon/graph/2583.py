from collections import deque
import sys

n, m, k = map(int, sys.stdin.readline().split())
graph = [[True for _ in range(m)] for _ in range(n)]
result_cnt = 0
result = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for _ in range(k):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            graph[j][i] = False

def bfs(x, y, cnt):
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if graph[ny][nx]:
                    graph[ny][nx] = False
                    cnt += 1
                    q.append((nx, ny))

    return cnt


for i in range(m):
    for j in range(n):
        if graph[j][i]:
            graph[j][i] = False
            result.append(bfs(i, j, 1))
            result_cnt += 1

print(result_cnt)
print(*sorted(result))
