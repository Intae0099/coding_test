#백트래킹 시 방문했던 노드 제외하기
import sys

n, m = map(int, sys.stdin.readline().split())
house = []
chicken_house = []
for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        if temp[j] == 1:
            house.append((i, j))
        elif temp[j] == 2:
            chicken_house.append((i, j))

len_chicken = len(chicken_house)
visited = [False] * len_chicken
result = 1e9

def dfs(idx, cnt):
    global result
    if cnt == m:
        temp = 0
        for dx, dy in house:
            dis = 1e9
            for i in range(len_chicken):
                if visited[i]:
                    dis = min(dis, abs(dx - chicken_house[i][0]) + abs(dy - chicken_house[i][1]))
            temp += dis
        result = min(result, temp)
        return

    for i in range(idx, len_chicken):
        if not visited[i]:
            visited[i] = True
            dfs(i + 1, cnt + 1)
            visited[i] = False


dfs(0, 0)
print(result)
