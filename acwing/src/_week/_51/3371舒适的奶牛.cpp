#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
typedef pair<int,int>PII;
int dx[5]={0,0,1,-1,0};
int dy[5]={1,-1,0,0,0};
bool st[1010][1010];

int work(int x,int y)
{
    int sum=0;
    for(int j=0;j<4;j++){ //这里就不用搜自己了
            int ux=x+dx[j],uy=y+dy[j];
            if(ux<0||uy<0||ux>1000||uy>1000)continue;
            sum+=st[ux][uy];
    }
    return sum;

}

int main()
{
    int n;
    cin>>n;
    int ans=0;
    for(int i=1;i<=n;i++){
        int x,y;
        scanf("%d%d",&x,&y);
        st[x][y]=true;
        //每次加入牛我们就看这个牛对其它牛的影响(以及自己)
        for(int j=0;j<5;j++){
            int ux=x+dx[j],uy=y+dy[j];
            if(ux<0||uy<0||ux>1000||uy>1000||!st[ux][uy])continue;
            if(work(ux,uy)==3)ans++;
            if(work(ux,uy)==4)ans--;
        }
        printf("%d\n",ans);
    }


    return 0;
}

// 作者：Jackle
// 链接：https://www.acwing.com/solution/content/115649/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。