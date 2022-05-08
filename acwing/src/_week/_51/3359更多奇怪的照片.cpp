#include <bits/stdc++.h>
using namespace std;
int main()
{
    int odd=0, even=0, n;
    cin>>n;
    for(int i=0; i<n; i++)
    {
        int x; cin>>x;
        if(x%2==0) even++;
        else odd++;
    }
    while(odd>even)
        odd-=2, even++;
    if(even>odd+1) even=odd+1;
    cout<<even+odd<<endl;
    return 0;
}

// 作者：Kx233
// 链接：https://www.acwing.com/solution/content/115464/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。