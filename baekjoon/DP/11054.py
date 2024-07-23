import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
n_reversed_list = n_list[::-1]

dp = [1] * n
reversed_dp = [1] * n

for i in range(n):
    for j in range(i+1, n):
        if n_list[i] < n_list[j]:
            dp[j] = max(dp[i] + 1, dp[j])
        if n_reversed_list[i] < n_reversed_list[j]:
            reversed_dp[j] = max(reversed_dp[i] + 1, reversed_dp[j])

result = [0] * n

for i in range(n):
    result[i] = dp[i] + reversed_dp[n - i - 1] - 1

print(max(result))
