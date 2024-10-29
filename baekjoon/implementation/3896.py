import sys

n = int(sys.stdin.readline())
result = 0
for _ in range(n):
    word = list(map(str, sys.stdin.readline().rstrip()))
    stack = []
    while word:
        if stack:
            if stack[-1] == word[-1]:
                stack.pop()
                word.pop()
            else:
                stack.append(word.pop())
        else:
            stack.append(word.pop())

    if not stack and not word:
        result += 1

print(result)
