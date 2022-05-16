#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
typedef pair<int, char> PIC;
const int N = 1e3+5;
PIC a[N];
int n,p,l[N],r[N],ans=N;
char c;
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>c>>p;
        a[i]=make_pair(p,c);
    }
    sort(a+1,a+n+1);
    for(int i=1;i<=n;i++){
        if(a[i].second=='G') {
            l[i]=l[i-1]+1;
        }else{
            l[i]=l[i-1];
        }
    }
    for(int i=n;i>=1;i--){
        if(a[i].second=='L') {
            r[i]=r[i+1]+1;
        }else{
            r[i]=r[i+1];
        }
         ans=min(ans,n-(l[i]+r[i]));
    }
    cout<<ans<<endl;
    return 0;
}

//作者：孤峰离尘
//链接：https://www.acwing.com/solution/content/116711/
//来源：AcWing
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。