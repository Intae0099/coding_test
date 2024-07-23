import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
dp = [0] * (n)

for i in range(n):
    dp[i] = max(dp[i], n_list[i])
    for j in range(i + 1, n):
        if n_list[i] < n_list[j]:
            dp[j] = max(dp[j], dp[i] + n_list[j])

print(max(dp))
