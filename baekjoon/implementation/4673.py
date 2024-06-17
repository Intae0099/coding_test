n_set = set()
for i in range(1, 10001):
    temp = i + sum(list(map(int, str(i))))
    n_set.add(temp)

for i in range(1, 10001):
    if i not in n_set:
        print(i)
