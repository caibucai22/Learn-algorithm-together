#include<bits/stdc++.h>

using namespace std;
const int N = 1e5+10;
int w[N];
int n;

int main()
{
    cin>>n;
    for(int i=1;i<=n;i++)cin>>w[i];
    for(int i=1;i<=n;i++){
        int t;cin >> t;
        w[i] -= t;
    }
    // 构造差分数组
    for(int i=n;i>1;i--){
        w[i] -= w[i-1];
    }
    // 目标 使差分数组全部变为0
    int a = 0,b = 0;
    for(int i=1;i<=n;i++){
        if(w[i] > 0) a+=w[i];
        else b -= w[i];
    }
    cout<<max(a,b)<<endl;
    return 0;
}