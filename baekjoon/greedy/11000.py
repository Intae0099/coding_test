import sys
import heapq

n = int(sys.stdin.readline())
n_list = []
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    n_list.append((a,b))

n_list.sort(key=lambda x:x[0])

heap = []
heapq.heappush(heap, n_list[0][1])

for i in range(1, n):
    if n_list[i][0] >= heap[0]:
        heapq.heappop(heap)
    heapq.heappush(heap, n_list[i][1])

print(len(heap))
