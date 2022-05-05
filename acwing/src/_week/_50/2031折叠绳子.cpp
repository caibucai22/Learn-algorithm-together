#include<bits/stdc++.h>

using namespace std;
const int N = 110;
double a[N];
int ret;
int n,l;

bool check(double p,int l,int r){
    while(l>=0 && r<n){
        // abs 距离绝对值
        if(abs(p-a[l]) == abs(a[r]-p)){
            l--;
            r++;
        }else{
            return false;
        }
    }
    return true;
}

int main()
{
    cin >> n>>l;
    int maxP = 0,minP = 10001;
    for(int i=0;i<n;i++){
        cin>>a[i];
    }

    // 枚举两个球之间的中点 如果能够让少的那一端全部匹配上 就算有效点
    sort(a,a+n);

    for(int i=1;i<n;i++){
        double p = (a[i]+a[i-1])*1.0/2.0;
        int l=i-1,r=i;
        if(check(p,l,r)){
            ret++;
        }
    }
    // 枚举每一个球的位置
    for(int i=1;i<n-1;i++){
        double p = a[i];
        int l=i,r=i;
        if(check(p,l,r)){
            ret++;
        }
    }
    cout<<ret<<endl;

    return 0;
}