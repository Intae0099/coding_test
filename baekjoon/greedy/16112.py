import sys

n, k = map(int, sys.stdin.readline().split())
n_list = sorted(list(map(int, sys.stdin.readline().split())))
cnt = 0
result = 0
for i in range(n):
    result += n_list[i] * cnt
    cnt += 1
    if cnt > k:
        cnt -= 1

print(result)
