import heapq
import sys


n = int(sys.stdin.readline())
n_list = []
for _ in range(n):
    n_list.append(int(sys.stdin.readline()))

n_list.sort()
result = 0
while len(n_list) > 1:
    a, b = heapq.heappop(n_list), heapq.heappop(n_list)
    result += a + b
    heapq.heappush(n_list, (a + b))

print(result)
