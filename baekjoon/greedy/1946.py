import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    n_list = []
    m_list = []
    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        n_list.append((a, b))
        m_list.append((a, b))

    n_list.sort(key=lambda x:x[0])
    m_list.sort(key=lambda x:x[1])
    max_1 = 1
    max_2 = 1
    rank_1 = n_list[0][1]
    rank_2 = m_list[0][0]
    for i in range(1, n):
        if rank_1 > n_list[i][1]:
            max_1 += 1
            rank_1 = n_list[i][1]

        if rank_2 > m_list[i][0]:
            max_2 += 1
            rank_2 = m_list[i][0]

    print(max(max_1, max_2))
