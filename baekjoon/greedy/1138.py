import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
result = []

for i in range(n-1, -1, -1):
    if n_list[i] == 0:
        result.insert(0, i+1)
    else:
        result.insert(n_list[i], i+1)

print(*result)
