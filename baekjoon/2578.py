import sys

n_list = []
for _ in range(5):
    n_list.append(list(map(int, sys.stdin.readline().split())))

m_list = []
for _ in range(5):
    m_list += list(map(int, sys.stdin.readline().split()))

def change(num):
    for i in range(5):
        if num in n_list[i]:
            for j in range(5):
                if n_list[i][j] == num:
                    n_list[i][j] = 0
                    return

def check():
    y_list = list(map(list, zip(*n_list)))
    cnt = 0
    for i in range(5):
        if 0 in n_list[i]:
            for j in range(5):
                if n_list[i][j] == 0:
                    continue
                else:
                    break
            else:
                cnt += 1
        if 0 in y_list[i]:
            for j in range(5):
                if y_list[i][j] == 0:
                    continue
                else:
                    break
            else:
                cnt += 1

    if n_list[0][0] == n_list[4][4]:
        for i in range(5):
            if n_list[i][i] == 0:
                continue
            else:
                break
        else:
            cnt += 1

    if n_list[0][4] == n_list[4][0]:
        for i in range(5):
            if n_list[i][4-i] == 0:
                continue
            else:
                break
        else:
            cnt += 1

    if cnt >= 3:
        return True
    else:
        return False

for i in range(25):
    change(m_list[i])
    if check():
        print(i+1)
        break
