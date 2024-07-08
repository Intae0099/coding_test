import sys

n = int(sys.stdin.readline())
alpha_dict = {}
alpha_list = [sys.stdin.readline().strip() for _ in range(n)]
max_num = 9
result = 0

for temp_list in alpha_list:
    temp_len = len(temp_list) - 1
    for i in temp_list:
        if i not in alpha_dict:
            alpha_dict[i] = 10 ** temp_len
        else:
            alpha_dict[i] += 10 ** temp_len
        temp_len -= 1

n_list = sorted(list(alpha_dict.values()), reverse=True)

for i in n_list:
    result += i * max_num
    max_num -= 1

print(result)
