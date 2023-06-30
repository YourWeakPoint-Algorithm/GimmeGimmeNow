# [B] 18870 (좌표 압축)
# boj.kr/18870

import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

sorted_lst = sorted(list(set(lst)))

dic = {}
for i in range(len(sorted_lst)):
    dic[sorted_lst[i]] = i

for target in lst:
    print(dic[target], end = " ")
