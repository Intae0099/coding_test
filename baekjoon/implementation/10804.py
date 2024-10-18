import sys

n_list = [i for i in range(1, 21)]

for _ in range(10):
    a, b = map(int, sys.stdin.readline().split())
    if a == b:
        continue
    elif a == 1:
        n_list = n_list[:b][::-1] + n_list[b:]
    elif b == 20:
        n_list = n_list[:a-1] + n_list[a-1:b][::-1]
    else:
        n_list = n_list[:a-1] + n_list[a-1:b][::-1] + n_list[b:]

print(*n_list)
