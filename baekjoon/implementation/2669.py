#xy 축 잘 보기
import sys

min_x, min_y, max_x, max_y = 0, 0, 0, 0

axis = []
for _ in range(4):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    min_x = min(min_x, x1)
    min_y = min(min_y, y1)
    max_x = max(max_x, x2)
    max_y = max(max_y, y2)
    axis.append([x1, y1, x2, y2])


visited = [[False] * (max_x+1) for _ in range(max_y + 1)]
result = 0
for xy in axis:
    x1, y1, x2, y2 = xy[0], xy[1], xy[2], xy[3]
    for x in range(x1, x2):
        for y in range(y1, y2):
            if not visited[y][x]:
                visited[y][x] = True
                result += 1

print(result)
