import sys

N = int(sys.stdin.readline())
N_list = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]


def func(x, y, n):
    paper = N_list[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper != N_list[i][j]:
                print('(', end='')
                func(x, y, n // 2)
                func(x, y + n // 2, n // 2)
                func(x + n // 2, y, n // 2)
                func(x + n // 2, y + n // 2, n // 2)
                print(')', end='')
                return
    if paper == 1:
        print(1, end='')
    else:
        print(0, end='')


func(0, 0, N)