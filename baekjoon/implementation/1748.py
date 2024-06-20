import sys

n = sys.stdin.readline().strip()
n_len = len(n)
result = (int(n) - 10 ** (n_len - 1) + 1) * n_len
for i in range(1, n_len):
    result += 9 * (10 ** (i-1)) * i

print(result)
