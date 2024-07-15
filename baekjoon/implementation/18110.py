import sys

n = int(sys.stdin.readline())

def rounding(num):
    if num - int(num) >= 0.5:
        return int(num) + 1
    else:
        return int(num)


if n == 0:
    print(0)
else:
    n_list = []
    for _ in range(n):
        n_list.append(int(sys.stdin.readline()))
    n_list.sort()
    k = rounding(n * 0.15)
    avg = rounding((sum(n_list[k : n - k]) / len(n_list[k : n - k])))
    print(avg)
