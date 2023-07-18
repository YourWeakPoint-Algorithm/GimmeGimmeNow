# [B] 1043 (거짓말)
# boj.kr/1043

import sys

input = sys.stdin.readline

n,m = map(int, input().split())

knowing = list(map(int, input().split()))[1:]

check = [True for _ in range(m)]

parties = []
person_to_party = {}

for i in range(1, n+1):
    person_to_party[i] = []

for i in range(m):
    lst = list(map(int,input().split()))[1:]
    parties.append(lst)
    for j in lst:
        person_to_party[j].append(i)

def search(target):
    global check
    if not check[target]:
        return
    check[target] = False
    next_targets = []
    for person in parties[target]:
        new_parties = person_to_party[person]
        for i in new_parties:
            if check[i]:
                next_targets.append(i)
    for i in next_targets:
        search(i)

for i in knowing:
    for j in person_to_party[i]:
        search(j)

count = 0
for i in check:
    if i:
        count += 1
print(count)