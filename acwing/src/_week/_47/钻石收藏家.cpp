#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>

using namespace std;

const int N = 1010;

int a[N];
int n,k;
int main()
{
    scanf("%d%d",&n,&k);
    for(int i=1;i<=n;i++)scanf("%d",&a[i]);
    
    sort(a+1,a+n+1);
    int cnt = 0;
    for(int i=1,j=1;i<=n;i++)
    {
        if(a[i]-a[j] > k)
        {
            j++;
        }
        else
        {
            cnt++;
        }
    }
    printf("%d",cnt);
    return 0;
}