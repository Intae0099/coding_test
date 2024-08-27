import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
n_list.sort()
x = int(sys.stdin.readline())

for i in range(n):
    if n_list[i] > x:
        n_list = n_list[:i]
        break

result = 0
start, end = 0, len(n_list) - 1
while start != end:
    if n_list[start] + n_list[end] > x:
        end -= 1
    elif n_list[start] + n_list[end] < x:
        start += 1
    else:
        result += 1
        start += 1

print(result)
