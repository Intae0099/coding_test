import sys

n = list(sys.stdin.readline().strip())

if '0' not in n:
    print(-1)
else:
    num_sum = 0
    for i in n:
        num_sum += int(i)

    if num_sum % 3 != 0:
        print(-1)
    else:
        n.sort(reverse=True)
        print(''.join(n))
