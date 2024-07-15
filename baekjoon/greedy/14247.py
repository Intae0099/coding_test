import sys

n = int(sys.stdin.readline())
n_list = list(map(int,sys.stdin.readline().split()))
m_list = list(map(int,sys.stdin.readline().split()))
result = []

for i in range(n):
    result.append((n_list[i], m_list[i]))

result.sort(key=lambda x:x[1])
cnt = 0
for i in range(n):
    cnt += result[i][0] + result[i][1] * i

print(cnt)
