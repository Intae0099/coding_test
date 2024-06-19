import sys

n = int(sys.stdin.readline())
n_list = []

for i in range(n):
    w, h = map(int, sys.stdin.readline().split())
    n_list.append([w, h])

for i in range(n):
    cnt = 1
    for j in range(i):
        if n_list[i][0] < n_list[j][0] and n_list[i][1] < n_list[j][1]:
            cnt += 1
    for j in range(i+1, n):
        if n_list[i][0] < n_list[j][0] and n_list[i][1] < n_list[j][1]:
            cnt += 1
    print(cnt, end=' ')
