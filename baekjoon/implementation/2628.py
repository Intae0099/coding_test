#좌표 착각하지 말기
import sys

n, m = map(int, sys.stdin.readline().split())
k = int(sys.stdin.readline())
x_list = [0, n]
y_list = [0, m]
for _ in range(k):
    a, b = map(int, sys.stdin.readline().split())
    if a == 0:
        y_list.append(b)
    else:
        x_list.append(b)

x_list.sort()
y_list.sort()

result = 0
for x in range(len(x_list) - 1):
    for y in range(len(y_list) - 1):
        result = max(result, (x_list[x+1] - x_list[x]) * (y_list[y+1] - y_list[y]))

print(result)
