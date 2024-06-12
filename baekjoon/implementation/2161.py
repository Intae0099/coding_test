from collections import deque
import sys

n = int(sys.stdin.readline())
q = deque([i for i in range(1, n+1)])
while q:
    print(q.popleft(), end=' ')
    if q:
        q.append(q.popleft())
