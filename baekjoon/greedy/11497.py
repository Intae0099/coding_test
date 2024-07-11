import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    n_list = sorted(list(map(int, sys.stdin.readline().split())))
    result = 0
    left_list = []
    right_list = []
    for i in range(n):
        if i % 2 == 0:
            left_list.append(n_list[i])
        else:
            right_list.append(n_list[i])

    for i in range(len(left_list)-1):
        result = max(result, left_list[i + 1] - left_list[i])

    for i in range(len(right_list)-1, 0, -1):
        result = max(result, right_list[i] - right_list[i-1])

    print(max(result, abs(left_list[-1] - right_list[-1])))
