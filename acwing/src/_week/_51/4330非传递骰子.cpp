#include <bits/stdc++.h>

using namespace std;

const int N = 5;

int a[N], b[N];
int n;

bool judge(int a[],int b[])
{
    int win = 0, lose = 0;

    for(int i = 0; i < 4; i ++ )
    {
        for(int j = 0; j < 4; j ++ )
        {
            if(a[i] > b[j]) win ++;
            if(a[i] < b[j]) lose ++;
        }
    }
    return win > lose;
}
bool solve(int a[],int b[])
{
    for(int i = 1; i <= 10; i ++ )
    {
        for(int j = 1; j <= 10; j ++ )
        {
            for(int k = 1; k <= 10; k ++ )
            {
                for(int u = 1; u <= 10; u ++ )
                {
                    int c[4] = {i, j, k, u};
                    if(judge(a, b) && judge(b, c) && judge(c, a)) return true;
                    if(judge(b, a) && judge(a, c) && judge(c, b)) return true;
                }
            }
        }
    }
    return false;
}
int main ()
{
    cin >> n;

    while(n -- )
    {
        for(int i = 0; i < 4; i ++ ) cin >> a[i];
        for(int i = 0; i < 4; i ++ ) cin >> b[i];

        if(solve(a, b)) cout << "yes" << endl;
        else cout << "no" << endl;
    }

    return 0;
}

// 作者：-任我行
// 链接：https://www.acwing.com/solution/content/116190/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。