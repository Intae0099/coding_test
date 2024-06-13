#문제 조건 잘 읽기
import sys

n, k = map(int, sys.stdin.readline().split())
n_list = []
rank_dict = {}
for _ in range(n):
    n_list.append(list(map(int, sys.stdin.readline().split())))

n_list.sort(key=lambda x:(x[1], x[2], x[3]), reverse=True)

rank = 1
temp = [n_list[0][0]]

for i in range(1, len(n_list)):
    if n_list[i-1][1:4] == n_list[i][1:4]:
        temp.append(n_list[i][0])
    else:
        rank_dict[rank] = temp
        rank += len(temp)
        temp = [n_list[i][0]]

rank_dict[rank] = temp

result = 0
for i in rank_dict.keys():
    if k in rank_dict[i]:
        result = i
        break


print(result)
