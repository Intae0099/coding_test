#누적합으로 연산시 더 빠르다
import sys

n, m = map(int, sys.stdin.readline().split())
n_list = []
for _ in range(n):
    n_list.append(list(map(int, sys.stdin.readline().split())))

k = int(sys.stdin.readline())
prefix = [[0] * (m+1) for _ in range(n+1)]

for p in range(1, n+1):
    for q in range(1, m+1):
        prefix[p][q] = n_list[p-1][q-1] + prefix[p-1][q] + prefix[p][q-1] - prefix[p-1][q-1]

for _ in range(k):
    i, j, x, y = map(int, sys.stdin.readline().split())
    result = prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1]
    print(result)
