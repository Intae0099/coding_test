import sys

word = sys.stdin.readline().strip()
goal_word = sys.stdin.readline().strip()

while len(word) != len(goal_word):
    if goal_word[-1] == 'A':
        goal_word = goal_word[:-1]
    else:
        goal_word = goal_word[:-1]
        goal_word = goal_word[::-1]

if word == goal_word:
    print(1)
else:
    print(0)
