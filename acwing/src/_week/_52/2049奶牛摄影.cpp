#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    unordered_map<int, int> mp[5];
    int n; cin >> n;
    for(int i = 0; i < 5; i++)
        for(int j = 0, x; j < n; j++) cin >> x, mp[i][x] = j;

    vector<int> v(n);
    for(int i = 0; i < n; i++) v[i] = i + 1;
    sort(v.begin(), v.end(), [&](int a, int b){
        int cnt = 0;
        for(int i = 0; i < 5; i++) cnt += (mp[i][a] < mp[i][b]);
        return cnt >= 3;
    });
    for(int i : v) cout << i << '\n';

    return 0;
}
//
//作者：Cyzh
//链接：https://www.acwing.com/solution/content/115467/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。