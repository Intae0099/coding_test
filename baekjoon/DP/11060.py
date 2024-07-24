import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
dp = [0] * n
cnt = 0
dp[0] = 1

if n == 1:
    print(0)
elif n_list[0] == 0:
    print(-1)
else:
    for i in range(n):
        if dp[i] == 0:
            continue
        cnt += 1
        for j in range(i + 1, i + n_list[i] + 1):
            if j == n:
                break
            if dp[j] == 0:
                dp[j] = min(cnt, dp[i] + 1)

    if dp[-1] != 0:
        print(dp[-1])
    else:
        print(-1)
