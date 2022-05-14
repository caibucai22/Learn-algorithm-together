#include <iostream>
#include <cstring>
#include <algorithm>
#include <set>
using namespace std;

// 大佬的双指针写法 ，写的暴力肯定超时
const int N = 1e5 + 7;
int w[N];
int main() {
    int n,a;
    cin >> n;
    for(int i = 0;i < n;i ++) cin >> w[i];
    set<int> st;
    for(int i = 0 , j = 0;i < n;i ++) {
        cin >> a;
        while(st.count(w[j])) j ++;// 移到前面的数字
        if(w[j] == a) j ++;
        else st.insert(a);
    }
    cout<<st.size()<<"\n";
    return 0;
}

//作者：daydayuppp
//链接：https://www.acwing.com/solution/content/116328/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。