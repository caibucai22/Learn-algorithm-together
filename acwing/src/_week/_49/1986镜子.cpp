#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;
typedef pair<int, int> PII;
const int N = 250, Null = 0x3f3f3f3f;

int n, a, b;
int res = Null;
int st[N];
PII mp[N];//保存镜子坐标
char g[N];//保存镜子状态

//判断是否可以到达终点
bool check(int x, int y, int fw)
{
    if (fw == 1 && x == 0 && y == 0) return false;
    //只有经过反射看到终点才算，所以这里特判一下
    return (fw == 0 && x == a && y < b || fw == 1 && y == b && x < a
         || fw == 2 && x == a && y > b || fw == 3 && y == b && x > a);
}


bool walk(int x, int y, int fw, int u)
{
    if (check(x, y, fw))
    {
        res = u;//将当前修改的镜子序号设为答案
        return true;//如果能到达终点就结束循环
    }
    int minx = Null, idx = 0;
    for (int i = 1; i <= n; i++)
    {
        if (st[i] >= 2) continue;//可能有镜子会重复使用，但是要防止死循环
        /*
        * 分析一下情况可以发现如果使用同一面反射，光线是同一条
        * 所以镜子的一面不能重复使用
        * 如果使用同一面镜子超过2次就说明至少有一面是重复使用过的
        * 这种情况是一定存在闭合环的，需要排除这种情况
        * 所以st[i] >= 2时就一定存在闭合环
        */
        int x1 = mp[i].first, y1 = mp[i].second;
        if ((fw == 1 && y1 == y && x1 > x) || (fw == 3 && y1 == y && x1 < x))
        { if (minx > abs(x - x1)) minx = abs(x - x1), idx = i; }
        else if ((fw == 2 && x1 == x && y1 < y) || (fw == 0 && x1 == x && y1 > y))
        { if (minx > abs(y - y1)) minx = abs(y - y1), idx = i; }
        //找到当前方向最近的镜子，并保存该镜子的序号
        else continue;//如果当前方向没有镜子就跳过
    }
    if (minx != Null)
    {
        st[idx]++;
        if (g[idx] == '/') fw ^= 1;
        else fw ^= 3;//根据镜子的状态改变方向
        return walk(mp[idx].first, mp[idx].second, fw, u);//深搜
    }
    else return false;//如果不能到达终点就结束
}

int main()
{
    ios::sync_with_stdio(0);cin.tie(0);
    cin >> n >> a >> b;
    for (int i = 1; i <= n; i++)
    {
        int x, y;
        char s;
        cin >> x >> y >> s;
        mp[i] = { x, y };//保存坐标
        g[i] = s;//保存状态
    }
    bool flag = walk(0, 0, 1, 0);//不改变镜子的情况下模拟一次
    for (int i = 1; i <= n && !flag; i++)
    {
        memset(st, 0, sizeof st);
        if (g[i] == '/') g[i] = '\\';
        else g[i] = '/';//改变第i个镜子并模拟
        flag = walk(0, 0, 1, i);
        if (g[i] == '/') g[i] = '\\';
        else g[i] = '/';//将第i个镜子状态还原
    }
    if (res == Null) cout << -1 << endl;
    else cout << res << endl;
    return 0;
}

// 作者：Dwjaid
// 链接：https://www.acwing.com/solution/content/113353/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。