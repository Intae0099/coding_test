import sys

s = int(sys.stdin.readline())
k = int((s * 2) ** 0.5)
for i in range(k, 0, -1):
    if i * (i+1) <= s * 2:
        print(i)
        break
