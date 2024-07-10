import sys

n = int(sys.stdin.readline())
n_list = []
result = 0
for _ in range(n):
    n_list.append(int(sys.stdin.readline()))

n_list.sort(reverse=True)

for i in range(0, n - (n % 3), 3):
    result += n_list[i] + n_list[i+1]

if n % 3 != 0:
    for i in range(n - (n % 3), n):
        result += n_list[i]


print(result)
