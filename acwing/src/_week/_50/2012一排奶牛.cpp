#include <bits/stdc++.h>
using namespace std;

const int N = 1010;
const int M = 1e6 + 10;
int a[N];
int st[M]; // 计数

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    int cnt = 0, j = 0, res = 0;
    for (int i = 0; i < n; i++) {
        if (!st[a[i]]) cnt++;
        st[a[i]]++;
        while (cnt > 2) {
            st[a[j]]--;
            if (st[a[j++]] == 0) cnt--;
        }
        res = max(res, st[a[i]]);
    }
    cout << res << endl;
    return 0;
}

// 作者：ICZK
// 链接：https://www.acwing.com/solution/content/115152/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。