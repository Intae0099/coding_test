import sys

n = int(sys.stdin.readline())
graph = [0] + list(map(int, sys.stdin.readline().split()))
dp = [0] * (n+1)
dp[1] = graph[1]
for i in range(1, n+1):
    for j in range(1, n+1):
        if i + j <= n:
            dp[i + j] = max(graph[i] + dp[j], dp[i + j], graph[i + j])


print(dp[-1])

"""
# 더 빠르다
import sys

n = int(sys.stdin.readline())
card = [0] + list(map(int, sys.stdin.readline().split()))
dp = [0] * (n+1)

for i in range(1, n+1):
    for j in range(1, i+1):
        if i > j:
            dp[i] = max(dp[i], dp[i - j] + card[j])
        else:
            dp[i] = max(dp[i], card[i])

print(dp[-1])
"""
