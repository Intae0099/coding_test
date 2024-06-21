#문제 조건 꼼꼼히 읽기 자료구조 생각해보기
import sys
from collections import deque

t = int(sys.stdin.readline())
for _ in range(t):
    command = list(sys.stdin.readline().strip())
    n = int(sys.stdin.readline())



    word = sys.stdin.readline().strip()[1:-1].split(',')
    q = deque(word)
    r_flag = 0
    if n == 0:
        q = []

    for com in command:
        if com == 'R':
            r_flag += 1
        else:
            if q:
                if r_flag % 2 == 0:
                    q.popleft()
                else:
                    q.pop()
            else:
                r_flag = 0
                print('error')
                break
    else:
        if r_flag % 2 == 0:
            print('[' + ','.join(q) + ']')
        else:
            q.reverse()
            print('[' + ','.join(q) + ']')
