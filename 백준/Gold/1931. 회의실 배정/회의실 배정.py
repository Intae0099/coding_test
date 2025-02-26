import sys

n = int(sys.stdin.readline())
time_list = []
for _ in range(n):
    time_list.append(list(map(int, sys.stdin.readline().split())))

time_list.sort(key=lambda x: (x[1], x[0]))

start_time = 0
cnt = 0

for i in time_list:
    if start_time <= i[0]:
        start_time = i[1]
        cnt += 1

print(cnt)
