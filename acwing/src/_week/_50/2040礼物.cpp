#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N=1100;
int a[N],b[N];
LL dp[N][N]; //表示考虑前i头牛，恰好选了j头牛，并且用了不超过k张优惠卷能买的牛的最小钱(这里用滚动数组压了一维)
int main()
{
    int n,m,cnt=1;
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        cin>>a[i]>>b[i]; //p和s
    }
    memset(dp,127,sizeof dp);
    for(int i=0;i<=cnt;i++)dp[0][i]=0;
    for(int i=1;i<=n;i++){
        for(int j=n;j>=0;j--){
            for(int k=cnt;k>=0;k--){
                //不用
                if(j)dp[j][k]=min(dp[j][k],dp[j-1][k]+a[i]+b[i]);
                //用
                if(k)dp[j][k]=min(dp[j][k],dp[j-1][k-1]+a[i]/2+b[i]);
            }
        }
    }
    for(int i=n;i>=0;i--){
        if(dp[i][cnt]<=m){
            cout<<i;
            break;
        }
    }
    return 0;
}
// 作者：Jackle
// 链接：https://www.acwing.com/solution/content/114584/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。