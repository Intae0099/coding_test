import sys

n = sys.stdin.readline().strip()
n_dict = {i:0 for i in range(10)}

for i in n:
    num = int(i)
    if num == 6:
        if n_dict[6] > n_dict[9]:
            n_dict[9] += 1
        else:
            n_dict[6] += 1
    elif num == 9:
        if n_dict[9] > n_dict[6]:
            n_dict[6] += 1
        else:
            n_dict[9] += 1
    else:
        n_dict[num] += 1

print(max(n_dict.values()))
