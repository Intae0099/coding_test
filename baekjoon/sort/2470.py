import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
n_list.sort()
start, end = 0, n - 1
min_result = 2000000001
result_start, result_end = 0, n-1

while start != end:
    if n_list[start] + n_list[end] == 0:
        result_start, result_end = start, end
        break
    else:
        if abs(n_list[start] + n_list[end]) < min_result:
            min_result = abs(n_list[start] + n_list[end])
            result_start, result_end = start, end

        if n_list[start] + n_list[end] > 0:
            end -= 1
        else:
            start += 1

print(n_list[result_start], n_list[result_end])
