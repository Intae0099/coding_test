import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))
visited = [False] * m

n_list.sort(reverse=True)
m_list.sort(reverse=True)

time = 0
idx = 0

if max(n_list) < max(m_list):
    time = -1
else:
    while visited.count(True) < m:
        for i in range(m):
            if not visited[i]:
                if n_list[idx] >= m_list[i]:
                    visited[i] = True
                    idx += 1

                # else:
                #     idx = 0
                #     time += 1
                #     break
            if idx >= n:
                idx = 0
                time += 1
                break
        else:
            idx = 0
            time += 1

if idx != 0:
    time += 1

print(time)
