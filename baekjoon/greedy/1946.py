import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    n_list = []
    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        n_list.append((a, b))

    n_list.sort(key=lambda x:x[0])
    max_1 = 1
    rank_1 = n_list[0][1]
    for i in range(1, n):
        if rank_1 > n_list[i][1]:
            max_1 += 1
            rank_1 = n_list[i][1]

    print(max_1)
