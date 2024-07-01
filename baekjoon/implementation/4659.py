import sys

v = ['a', 'e', 'i', 'o', 'u']

while True:
    word = sys.stdin.readline().strip()
    if word == 'end':
        break

    result = False

    #1
    for i in v:
        if i in word:
            result = True
            break

    if not result:
        print('<'+ word + '> is not acceptable.')
        continue
    else:
        #2
        flag = 0
        for i in word:
            if flag >= 0:
                if i not in v:
                    flag += 1
                else:
                    flag = -1
            else:
                if i not in v:
                    flag = 1
                else:
                    flag -= 1
            if flag >= 3 or flag <= -3:
                result = False
                break

        if not result:
            print('<' + word + '> is not acceptable.')
            continue
        else:
            #3
            for i in range(len(word) - 1):
                if word[i] == word[i+1]:
                    if word[i] == 'e' or word[i] == 'o':
                        continue
                    else:
                        result = False
                        print('<' + word + '> is not acceptable.')
                        break
            else:
                print('<' + word + '> is acceptable.')
