// 2 10 7 1
// -3 +5 +2 -4
#include<bits/stdc++.h>

using namespace std;

const int N  = 10010;
int a[N];
int n;
int main()
{
    cin>>n;
    int sum = 0;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
        sum += a[i];
    }
    int aver = sum/n;
    int ret = 0;
    for(int i=0;i<n;i++)
    {
        if(a[i]<aver)ret += aver-a[i];
    }

    cout<<ret;

    return 0;
}