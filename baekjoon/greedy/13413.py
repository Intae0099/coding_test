import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    n_list = list(sys.stdin.readline().strip())
    goal_list = list(sys.stdin.readline().strip())
    cnt = 0

    for i in range(n):
        if n_list[i] != goal_list[i]:
            cnt += 1

    if n_list.count('B') != goal_list.count('B'):
        temp = abs(n_list.count('B') - goal_list.count('B'))
        cnt = (cnt - temp) // 2 + temp
    else:
        cnt //= 2

    print(cnt)
