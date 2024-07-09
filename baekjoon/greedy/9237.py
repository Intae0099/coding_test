import sys

n = int(sys.stdin.readline())
n_list = sorted(list(map(int, sys.stdin.readline().split())), reverse=True)
result = [0] * n
for i in range(n):
    result[i] = n_list[i] - n + i + 1

print(max(result) + n + 1)
