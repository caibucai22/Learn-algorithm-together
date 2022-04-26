#include<bits/stdc++.h>

using namespace std;

const int N = 50010;
const int M = 1000010;
int a[N],b[N]; //记录移动距离
char ca[N],cb[N]; //记录移动方向
bool st[M]; //标记相遇


int main()
{
    int n,m;
    cin >>n>>m;
    for(int i=0;i<n;i++)cin>>a[i]>>ca[i];
    for(int i=0;i<m;i++)cin>>b[i]>>cb[i];

    int na =0,nb =0;
    int i=0,j=0;
    int ans = 0;
    st[0] = true;


    for(int t=1;t<=M;t++)
    {
        if(i < n)
        {
            if(ca[i] == 'L')na--;
            else na++;
        }
        a[i]--;if(a[i]==0)i++;

        if(j < m)
        {
            if(cb[j] == 'L')nb--;
            else nb++;
        }
        b[j]--;if(b[j]==0)j++;


        if(i>=n&&j>=m)break;

        if(na == nb){
            st[t] = true;
            if(!st[t-1])ans++;
        }
    }
    cout<<ans;

    return 0;
}