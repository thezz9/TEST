#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

int N, M, K;
vector<ll> arr, tree;

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
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M >> K;
    arr.resize(N + 1);
    tree.resize(N * 4);

    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
    }

    build(1, 1, N);

    for (int i = 0; i < M + K; i++) {
        int a, b;
        ll c;
        cin >> a >> b >> c;
        if (a == 1) {
            ll diff = c - arr[b];
            arr[b] = c;
            update(1, 1, N, b, diff);
        } else {
            cout << query(1, 1, N, b, (int)c) << '\n';
        }
    }

    return 0;
}
