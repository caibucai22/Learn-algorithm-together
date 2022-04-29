#include<bits/stdc++.h>

using namespace std;

const int N = 1000010;
// 枚举出每一秒的位置
int a[N],b[N];
int ret;

int main()
{
    int n,m;cin>>n>>m;

    int time = 0;


    int idx = 1;
    for(int i=1;i<=n;i++){
        int v,t;
        cin>>v>>t;
        time += t;
        for(int j=1;j<=t;j++){
            a[idx] = a[idx-1]+v;
            idx++;
        }

    }
    idx = 1;
    for(int i=1;i<=m;i++){
        int v,t;
        cin>>v>>t;
        for(int j=1;j<=t;j++){
            b[idx] = b[idx-1]+v;
            idx++;
        }

    }
    int leader  = 0; // 1 bessie -1 aixi

    for(int i=1;i<=time;i++){
        // if((a[i]<b[i]) != (a[i-1] < b[i-1]))ret++;
        //状态的判断
        // if(a[i]>=b[i] && a[i-1]<b[i-1])ret++;
        // if(a[i]<=b[i] && a[i-1]>b[i-1])ret++;
        // cout<<a[i]<<" "<<b[i]<<endl;
        if(a[i]>b[i]){
            if(leader == -1)ret++;
            leader = 1;
        }
        else if(a[i]<b[i]){
            if(leader == 1)ret++;
            leader = -1;
        }
    }
    cout<<ret<<endl;

    return 0;
}