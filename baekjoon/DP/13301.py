import sys

n = int(sys.stdin.readline())

dp = [0, 1, 1] + [0] * (n+1)

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[n] * 4 + dp[n-1] * 2)
