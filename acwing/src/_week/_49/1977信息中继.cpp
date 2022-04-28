#include<bits/stdc++.h>

using namespace std;

const int N = 1010;

int ne[N];
int cnt[N];

bool cycle(int i)
{
    bool flag = false;
    while(true)
    {
        i = ne[i];
        if(i == 0)break;
        else if(cnt[i] >= 1)
        {
            flag = true;
            break;
        }
        cnt[i] = 1;
    }
    return flag;
}

// 查考 栗子ing 题解
int main()
{
    int n = 0,ret = 0;
    cin >> n;
    for(int i=1;i<=n;i++)cin>>ne[i];

    for(int i=1;i<=n;i++)
    {
        memset(cnt,0,sizeof cnt);
        if(!cycle(i))ret++;
    }
    cout<<ret<<endl;

    return 0;
}