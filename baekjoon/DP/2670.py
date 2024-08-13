import sys

n = int(sys.stdin.readline())
n_list = []
for _ in range(n):
    n_list.append(float(sys.stdin.readline()))

dp = [0.0] * n
dp[0] = n_list[0]
for i in range(n):
    for j in range(i+1, n):
        if n_list[j] < n_list[j] * dp[j-1]:
            dp[j] = max(dp[j], n_list[j] * dp[j-1])
        else:
            dp[j] = n_list[j]
            break

print("%.3f" % max(dp))
