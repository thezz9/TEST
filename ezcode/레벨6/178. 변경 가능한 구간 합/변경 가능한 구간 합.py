import sys
input = sys.stdin.readline

def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return
    mid = (start + end) // 2
    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]

def update(node, start, end, idx, diff):
    if idx < start or idx > end:
        return
    tree[node] += diff
    if start == end:
        return
    mid = (start + end) // 2
    update(node * 2, start, mid, idx, diff)
    update(node * 2 + 1, mid + 1, end, idx, diff)

def query(node, start, end, left, right):
    if right < start or end < left:
        return 0
    if left <= start and end <= right:
        return tree[node]
    mid = (start + end) // 2
    return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right)

N, M, K = map(int, input().split())
arr = [0] + [int(input()) for _ in range(N)]
tree = [0] * (4 * N)

build(1, 1, N)

for _ in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:
        diff = c - arr[b]
        arr[b] = c
        update(1, 1, N, b, diff)
    else:
        print(query(1, 1, N, b, c))
