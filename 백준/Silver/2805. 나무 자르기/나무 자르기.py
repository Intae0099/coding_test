import sys

n, m = map(int, sys.stdin.readline().split())
n_list = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(n_list)

while start <= end:
    mid = (start + end) // 2
    tree = 0
    for i in n_list:
        if i > mid:
            tree += i - mid

    if tree >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)