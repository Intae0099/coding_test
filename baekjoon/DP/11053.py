import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))

dp = [1] * n

for i in range(n):
    for j in range(i+1, n):
        if n_list[i] < n_list[j]:
            dp[j] = max(dp[i] + 1, dp[j])

print(max(dp))
