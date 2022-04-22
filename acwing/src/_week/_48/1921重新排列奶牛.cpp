#include <bits/stdc++.h>
using namespace std;
const int N=110;

int n;
int a[N], b[N], pos[N];
bool st[N];

int cycle(int be)
{
    int cnt=0;
    int i=be;
    do
    {
        st[i]=true;
        i=pos[a[i]];
        cnt++;
    }while(i!=be);
    return cnt;
}
// 环图 并查集
int main()
{
    int res=0, len=-1;
    cin>>n;
    for(int i=1; i<=n; i++) cin>>a[i];
    for(int i=1; i<=n; i++)
    {
        cin>>b[i];
        pos[b[i]]=i;
    }
    for(int i=1; i<=n; i++)
    {
        if(a[i]!=b[i] && !st[i])
        {
            len=max(len, cycle(i));
            res++;
        }
    }
    cout<<res<<" "<<len;
    return 0;
}