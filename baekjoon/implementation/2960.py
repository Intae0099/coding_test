#다방면으로 생각해보기
import sys

n, k = map(int, sys.stdin.readline().split())

n_list = [False] * (n+1)
cnt = 0
result = 0
for i in range(2, n+1):
    for j in range(i, n+1, i):
        if not n_list[j]:
            n_list[j] = True
            cnt += 1
            if cnt == k:
                result = j
                break
    if cnt == k:
        break

print(result)
