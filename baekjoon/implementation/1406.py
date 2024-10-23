import sys

word = list(map(str, sys.stdin.readline().rstrip()))
cursor = []
t = int(sys.stdin.readline())
for _ in range(t):
    cmd = list(map(str, sys.stdin.readline().split()))

    if cmd[0] == "L":
        if word:
            cursor.append(word.pop())
    elif cmd[0] == "D":
        if cursor:
            word.append(cursor.pop())
    elif cmd[0] == "B":
        if word:
            word.pop()
    else:
        word.append(cmd[1])

word = word + cursor[::-1]

print(''.join(word))

