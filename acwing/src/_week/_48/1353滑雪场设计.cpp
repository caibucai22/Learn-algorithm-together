#include<iostream>
#include<cstdio>

using namespace std;
const int N = 1010;
int n;
int a[N];
int main()
{
    cin >> n;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    int ret = 1 << 30;
    int mi,mx,cnt;
    for(int h=1;h<100-17;h++)
    {
        mi = h-17,mx = h;
        cnt  = 0;
        for(int i=0;i<n;i++)
        {
            if(a[i] > mx) cnt += (a[i]-mx)*(a[i]-mx);
            else if(a[i] < mi) cnt += (mi-a[i])*(mi-a[i]);
        }
        ret = min(ret,cnt);
    }
    cout<<ret<<endl;
    return 0;
}