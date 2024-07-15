import sys

n, k = map(int, sys.stdin.readline().split())
dp = [i for i in range(n+1)]

if k == 0 or k == n:
    print(1)
else:
    for i in range(2, n+1):
        dp[i] = (dp[i] * dp[i-1])
    print(((dp[n] // dp[k]) // dp[n-k]) % 10007)
