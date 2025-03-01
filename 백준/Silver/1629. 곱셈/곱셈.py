import sys

a, b, c = map(int, sys.stdin.readline().split())

def func(x, n):
    if n == 1:
        return x % c
    else:
        temp = func(x, n//2)
        if n % 2 == 0:
            return (temp * temp) % c
        else:
            return (temp * temp * a) % c

print(func(a, b))