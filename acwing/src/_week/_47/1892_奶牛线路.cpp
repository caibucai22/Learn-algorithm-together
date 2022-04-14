#include<iostream>
#include<cstdio>
#include<cstring>

using namespace std;
const int N = 510;

int r[N];
int ret = 1001;
int main()
{
    // 判断每个航线是否包含起始-> 目的路线 包含就进行更新
    int a,b,n;
    scanf("%d%d%d",&a,&b,&n);

    while(n--)
    {
        memset(r,0,sizeof r);
        int p,m;
        scanf("%d%d",&p,&m);
        int aIdx = -1,bIdx = -1;
        for(int i =1;i<=m;i++)
        {
            scanf("%d",&r[i]);
            if(r[i] == a)aIdx = i;
            if(r[i] == b)bIdx = i;
        }

        if(aIdx!=-1 && bIdx!=-1 && aIdx < bIdx) ret = min(ret,p);
    }

    if(ret != 1001)printf("%d",ret);
    else puts("-1");
    return 0;
}