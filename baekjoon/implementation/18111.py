import sys

n, m, b = map(int, sys.stdin.readline().split())
board = []
for _ in range(n):
    board += list(map(int, sys.stdin.readline().split()))

dp = [0] * 257
result = 0

for i in range(257):
    block = b
    for j in board:
        if i <= j:              # 블록 부수기 2초
            block += j - i
            dp[i] += (j - i) * 2
        else:                   # 블록 설치 1초
            block -= i - j
            dp[i] += (i - j)

    if block >= 0 and dp[i] <= dp[result]:
        result = i

print(dp[result], result)
