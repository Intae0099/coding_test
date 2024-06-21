import sys

n, p = map(int, sys.stdin.readline().split())
n_list = [n]
idx = 0
temp = 0
while True:
    k = 0
    for j in str(n_list[idx]):
        k += int(j) ** p
    if k in n_list:
        temp = k
        break
    else:
        n_list.append(k)
        idx += 1

print(len(n_list[:n_list.index(temp)]))
