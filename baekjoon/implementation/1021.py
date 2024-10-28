from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())
n_list = list(map(int, sys.stdin.readline().split()))

q = deque([i for i in range(1, n+1)])
result = 0
for i in n_list:
    if i in list(q)[:(len(q)//2)+1]:
        while True:
            if q[0] == i:
                q.popleft()
                break
            else:
                q.append(q.popleft())
                result += 1
    elif i in list(q)[(len(q)//2)+1:]:
        while True:
            if q[0] == i:
                q.popleft()
                break
            else:
                q.appendleft(q.pop())
                result += 1

print(result)
