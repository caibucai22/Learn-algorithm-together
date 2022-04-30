#include <bits/stdc++.h>
using namespace std;
int dx[]={-1, 0, 1, 0}, dy[]={0, 1, 0, -1};

struct Point
{
    int y, x;
}pos[4]={{0,0}, {0,1}, {1,0}, {1,1}};//初始位置

int dir;//0: north, 1: west, 2: south, 3: east
int miny, minx, maxy, maxx;

int move(string s)
{
    int f=0;//确定脚的序号
    if(s[0]=='F' && s[1]=='R') f=1;
    else if(s[0]=='R')
        if(s[1]=='L') f=2;
        else f=3;
    if(s[2]=='P')//顺时针旋转
    {
        for(int i=0; i<4; i++)
        {
            int ny=pos[f].y+pos[i].x-pos[f].x;
            int nx=pos[f].x+pos[f].y-pos[i].y;
            pos[i].y=ny,pos[i].x=nx;
        }
        dir=(dir+1)%4;
    }
    else//移动
    {
        int m=0;//得到相对方向
        if(s[2]=='R') m=1;
        if(s[2]=='B') m=2;
        if(s[2]=='L') m=3;
        m=(m+dir)%4;//计算绝对方向
        pos[f].y+=dx[m];
        pos[f].x+=dy[m];
        for(int i=0; i<4; i++)//检查Bessie是否跌倒
            if(f!=i && pos[f].y==pos[i].y && pos[f].x==pos[i].x)
                return 0;
    }
    for(int i=0; i<4; i++)//更新矩形的最小大小
    {
        if(miny>pos[i].y) miny=pos[i].y;
        if(maxy<pos[i].y) maxy=pos[i].y;
        if(minx>pos[i].x) minx=pos[i].x;
        if(maxx<pos[i].x) maxx=pos[i].x;
    }
    return 1;
}

int main()
{
    int n; cin>>n;
    bool flag=1;
    string s;
    for(int i=0; i<n; i++)
    {
        cin>>s;
        if(!(flag=move(s))) break;
    }
    if(flag) cout<<(maxy-miny+1)*(maxx-minx+1);
    else puts("-1");
    return 0;
}

// 作者：Kx233
// 链接：https://www.acwing.com/solution/content/113758/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。