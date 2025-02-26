import sys

n, k = map(int, sys.stdin.readline().split())
knapsack = [[0,0]]
for _ in range(n):
    knapsack.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * (k+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, k+1):
        if knapsack[i][0] <= j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - knapsack[i][0]] + knapsack[i][1])
        else:
            dp[i][j] = dp[i-1][j]

print(max(dp[-1]))