// 得到所有奶牛的所在横线 x 竖线y
// 如果 x+y 种类不超过三种 即可覆盖 好像不太对
// 每一个点都可以选择是用 横线覆盖 还是 竖线覆盖 两种状态 dfs 线 线的数目 而不是牛的数目

#include<bits/stdc++.h>
using namespace std;
using T = pair<int,int>;

vector<T> cows;
map<int,bool> cx,cy;
int n;

bool dfs(int cur,int use){
    if(use > 3)return false; // 提前终止掉 而不是一直去枚举牛
    if(cur == n)return true;

    int x = cows[cur].first,y = cows[cur].second;
    if(cx[x]|cy[y]) return dfs(cur+1,use); // 已经被覆盖就不加线

    bool can = false;

    if(!cx[x])cx[x] = true,can |= dfs(cur+1,use+1),cx[x] = false;
    if(!cy[y])cy[y] = true,can |= dfs(cur+1,use+1),cy[y] = false;

    return can;
}

int main(){

    cin>>n;
    for(int i=0;i<n;i++){
        int x,y;
        cin>>x>>y;
        cows.push_back({x,y});
    }

    cout<<dfs(0,0)<<endl;

    return 0;
}