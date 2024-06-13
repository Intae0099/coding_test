import sys

n = int(sys.stdin.readline())
s = set()
for _ in range(n):
    word = list(map(str, sys.stdin.readline().split()))
    if word[0] == 'add':
        s.add(int(word[1]))
    elif word[0] == 'remove':
        if int(word[1]) in s:
            s.remove(int(word[1]))
    elif word[0] == 'check':
        if int(word[1]) in s:
            print(1)
        else:
            print(0)
    elif word[0] == 'toggle':
        if int(word[1]) in s:
            s.remove(int(word[1]))
        else:
            s.add(int(word[1]))
    elif word[0] == 'all':
        s = {i for i in range(1, 21)}
    elif word[0] == 'empty':
        s = set()
