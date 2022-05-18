#include <iostream>

using namespace std;

const int N = 20, INF = 1e4 + 5, FULL_AREA = 4 * INF * INF;
int n, ans;

struct Rect {
    int x1, y1, x2, y2;

    int area()const {
        return max(0, (x2 - x1)) * max(0, (y1 - y2));
    }

    // int joint_area(const Rect& R)const {
    //     int w = max(0, min(x2, R.x2) - max(x1, R.x1));
    //     int h = max(0, min(y1, R.y1) - max(y2, R.y2));
    //     return w * h;
    // }

    Rect join(const Rect& R)const {
        return {
            max(x1, R.x1), min(y1, R.y1),
            min(x2, R.x2), max(y2, R.y2)
        };
    }
} rects[N];

void dfs(int i, Rect joint, int sign) {
    if (i == n) {
        int area = joint.area();
        if (area < FULL_AREA)
            ans += sign * area;
        return;
    }

    dfs(i + 1, joint, sign);

    auto r = joint.join(rects[i]);
    if (r.area())
        dfs(i + 1, r, sign * -1);
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i ++) {
        auto& [x1, y1, x2, y2] = rects[i];
        cin >> x1 >> y1 >> x2 >> y2;
    }

    dfs(0, {-INF, INF, INF, -INF}, -1);
    cout << ans << endl;

    return 0;
}

// 作者：美琴
// 链接：https://www.acwing.com/solution/content/117071/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。