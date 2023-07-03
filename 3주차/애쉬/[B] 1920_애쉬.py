# [B] 1920 (수 찾기)
# boj.kr/1920

import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

m = int(input())
targets = list(map(int, input().split()))

lst.sort()

def search(target, lst, start, end):
    if start > end:
        return 0
    mid = (start+end)//2
    if lst[mid] == target:
        return 1
    elif lst[mid] > target:
        return search(target, lst, start, mid-1)
    else:
        return search(target, lst, mid+1, end)

for i in targets:
    print(search(i, lst, 0, len(lst)-1))

