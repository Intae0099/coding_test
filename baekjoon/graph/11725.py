# DFS
import sys
sys.setrecursionlimit(10**6)

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

result = [0] * (n+1)

def dfs(num):
    for i in graph[num]:
        if result[i] == 0:
            result[i] = num
            dfs(i)


dfs(1)
for i in result[2:]:
    print(i)


"""
# BFS

from collections import deque
import sys

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

result = [0] * (n+1)
q = deque()
q.append(1)

while q:
    x = q.popleft()
    for i in graph[x]:
        if result[i] == 0:
            result[i] = x
            q.append(i)

for i in result[2:]:
    print(i)

"""
