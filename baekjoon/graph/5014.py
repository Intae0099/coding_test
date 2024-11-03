from collections import deque
import sys

f, s, g, u, d = map(int, sys.stdin.readline().split())
floor = [0 for _ in range(f + 1)]
floor[s] = 1


def bfs(x):
    q = deque()
    q.append(x)
    while q:
        x = q.popleft()
        if x == g:
            return floor[x] - 1
        for i in (x-d, x + u):
            if 0 < i <= f and not floor[i]:
                q.append(i)
                floor[i] = floor[x] + 1

    return "use the stairs"


print(bfs(s))
