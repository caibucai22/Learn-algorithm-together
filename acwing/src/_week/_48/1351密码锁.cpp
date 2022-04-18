#include<bits/stdc++.h>
using namespace std;
int a[3],b[3],c[3];
int n;
bool check(int a[]){//检测当前的c数组是否与a相差2以内
    for(int i = 0; i < 3; i++){
        if(abs(a[i]-c[i])>2 && n-abs(a[i]-c[i])>2) return false;//正向距离和反向距离均大于2则不合法
    }
    return true;
}
int main(){
    cin>>n;
    for(int i = 0; i < 3; i++) cin>>a[i];
    for(int i = 0; i < 3; i++) cin>>b[i];
    int ans = 0;
    for(c[0] = 1; c[0] <= n; c[0]++){//暴力枚举密码锁的三个取值
        for(c[1] = 1; c[1] <= n; c[1]++){
            for(c[2] = 1; c[2] <= n; c[2]++){
                if(check(a)||check(b)) ans++;
            }
        }
    }
    cout<<ans;
    return 0;
}