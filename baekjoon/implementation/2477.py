import sys

k = int(sys.stdin.readline())
line_list = [[] for _ in range(5)]
order_list = []
num_list = []

for _ in range(6):
    line_num, line_len = map(int, sys.stdin.readline().split())
    line_list[line_num].append(line_len)
    order_list.append(line_len)
    num_list.append(line_num)

max_width = max(max(line_list[1]), max(line_list[2]))
max_height = max(max(line_list[3]), max(line_list[4]))

total_square = max_width * max_height
sub_square = 0

if max_height in line_list[4]:
    if max_width in line_list[2]:
        order = num_list.index(2)
        sub_square = order_list[(order + 2) % 6] * order_list[(order + 3) % 6]
    else:
        order = num_list.index(4)
        sub_square = order_list[(order + 2) % 6] * order_list[(order + 3) % 6]
else:
    if max_width == line_list[2][0]:
        order = num_list.index(3)
        sub_square = order_list[(order + 2) % 6] * order_list[(order + 3) % 6]
    else:
        order = num_list.index(1)
        sub_square = order_list[(order + 2) % 6] * order_list[(order + 3) % 6]

print(k * (total_square - sub_square))
