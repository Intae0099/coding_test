import sys

n, m = map(int, sys.stdin.readline().split())
a = []
for _ in range(n):
    a.append(list(map(int, sys.stdin.readline().split())))

m, k = map(int, sys.stdin.readline().split())
b = []
for _ in range(m):
    b.append(list(map(int, sys.stdin.readline().split())))


result = [[0] * k for _ in range(n)]

for i in range(n):
    for j in range(k):
        temp = 0
        for p in range(m):
            temp += a[i][p] * b[p][j]
        result[i][j] = temp

for i in result:
    print(*i)
