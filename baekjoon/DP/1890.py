import sys

n = int(sys.stdin.readline())
graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if dp[i][j] != 0 and graph[i][j] != 0:
            if i + graph[i][j] < n:
                dp[i + graph[i][j]][j] += dp[i][j]
            if j + graph[i][j] < n:
                dp[i][j + graph[i][j]] += dp[i][j]

print(dp[n-1][n-1])
