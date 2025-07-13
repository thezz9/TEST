#include <stdio.h>

#define MAX 1000001
typedef long long ll;

ll arr[MAX], tree[MAX * 4];
int N, M, K;

void build(int node, int start, int end) {
    if (start == end) {
        tree[node] = arr[start];
        return;
    }
    int mid = (start + end) / 2;
    build(node * 2, start, mid);
    build(node * 2 + 1, mid + 1, end);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

void update(int node, int start, int end, int idx, ll diff) {
    if (idx < start || idx > end) return;
    tree[node] += diff;
    if (start == end) return;
    int mid = (start + end) / 2;
    update(node * 2, start, mid, idx, diff);
    update(node * 2 + 1, mid + 1, end, idx, diff);
}

ll query(int node, int start, int end, int left, int right) {
    if (right < start || end < left) return 0;
    if (left <= start && end <= right) return tree[node];
    int mid = (start + end) / 2;
    return query(node * 2, start, mid, left, right) +
           query(node * 2 + 1, mid + 1, end, left, right);
}

int main() {
    scanf("%d %d %d", &N, &M, &K);
    for (int i = 1; i <= N; i++) {
        scanf("%lld", &arr[i]);
    }

    build(1, 1, N);

    for (int i = 0; i < M + K; i++) {
        int a, b;
        ll c;
        scanf("%d %d %lld", &a, &b, &c);
        if (a == 1) {
            ll diff = c - arr[b];
            arr[b] = c;
            update(1, 1, N, b, diff);
        } else {
            printf("%lld\n", query(1, 1, N, b, (int)c));
        }
    }

    return 0;
}
