import sys

n = sys.stdin.readline().strip()
cnt = 0
while len(n) > 1:
    temp = 0
    for i in n:
        temp += int(i)
    n = str(temp)
    cnt += 1

if int(n) % 3 == 0:
    print(cnt)
    print('YES')
else:
    print(cnt)
    print('NO')
