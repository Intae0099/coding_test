import sys

stick = list(map(str, sys.stdin.readline().rstrip()))
stack = []
result = 0
for i in range(len(stick)):
    if stack:
        if stick[i] == ')':
            if stick[i-1] == ')':
                result += 1
                stack.pop()
            else:
                stack.pop()
                result += len(stack)
        else:
            stack.append(stick[i])
    else:
        stack.append(stick[i])

print(result)
