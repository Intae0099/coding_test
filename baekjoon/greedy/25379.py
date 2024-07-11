import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))

odd, even = 0, 0
result_even, result_odd = 0, 0


for i in n_list:
    if i % 2 == 1:
        odd += 1
        result_even += even
    else:
        even += 1
        result_odd += odd

print(min(result_odd, result_even))
