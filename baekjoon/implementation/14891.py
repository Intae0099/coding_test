#1시간정도 걸렸다 설계를 조금 더 잘해보자
from collections import deque
import sys

def dire_turn(dire, n_list):
    if dire == 1:
        n_list.appendleft(n_list.pop())
    else:
        n_list.append(n_list.popleft())
    return n_list


a = deque(list(map(int, sys.stdin.readline().strip())))
b = deque(list(map(int, sys.stdin.readline().strip())))
c = deque(list(map(int, sys.stdin.readline().strip())))
d = deque(list(map(int, sys.stdin.readline().strip())))
k = int(sys.stdin.readline())

for _ in range(k):
    num, turn = map(int, sys.stdin.readline().split())
    a_flag, b_flag, c_flag, d_flag = False, False, False, False
    if num == 1:
        if a[2] != b[6]:
            b_flag = True
            if b[2] != c[6]:
                c_flag = True
                if c[2] != d[6]:
                    d_flag = True

        a = dire_turn(turn, a)
        if b_flag:
            turn *= -1
            b = dire_turn(turn, b)
            if c_flag:
                turn *= -1
                c = dire_turn(turn, c)
                if d_flag:
                    turn *= -1
                    d = dire_turn(turn, d)

    elif num == 2:
        if b[6] != a[2]:
            a_flag = True
        if b[2] != c[6]:
            c_flag = True
            if c[2] != d[6]:
                d_flag = True
        b = dire_turn(turn, b)
        if a_flag:
            a = dire_turn((turn * -1), a)
        if c_flag:
            turn *= -1
            c = dire_turn(turn, c)
            if d_flag:
                turn *= -1
                d = dire_turn(turn, d)

    elif num == 3:
        if c[6] != b[2]:
            b_flag = True
            if b[6] != a[2]:
                a_flag = True
        if c[2] != d[6]:
            d_flag = True

        c = dire_turn(turn, c)
        if d_flag:
            d = dire_turn((turn * -1), d)
        if b_flag:
            turn *= -1
            b = dire_turn(turn, b)
            if a_flag:
                turn *= -1
                a = dire_turn(turn, a)

    elif num == 4:
        if d[6] != c[2]:
            c_flag = True
            if c[6] != b[2]:
                b_flag = True
                if b[6] != a[2]:
                    a_flag = True

        d = dire_turn(turn, d)
        if c_flag:
            turn *= -1
            c = dire_turn(turn, c)
            if b_flag:
                turn *= -1
                b = dire_turn(turn, b)
                if a_flag:
                    turn *= -1
                    a = dire_turn(turn, a)


result = a[0] * 1 + b[0] * 2 + c[0] * 4 + d[0] * 8
print(result)
