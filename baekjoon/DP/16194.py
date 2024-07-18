import sys

n = int(sys.stdin.readline())
dp = [0] + list(map(int, sys.stdin.readline().split()))

for i in range(1, n+1):
    for j in range(i, n+1):
        if i + j <= n:
            dp[i+j] = min(dp[i+j], dp[i] + dp[j])

print(dp[-1])
