#include<iostream>
#include<cstdio>

using namespace std;
typedef pair<int,int> PII;
const int N = 100010;

PII a[N];
int n;

int main()
{
    scanf("%d",&n);
    int sum = 0;
    for(int i=1;i<=n;i++)scanf("%d%d",&a[i].first,&a[i].second);
    for(int i=2;i<=n;i++)
    {
        sum += abs(a[i-1].first - a[i].first) + abs(a[i-1].second - a[i].second);
    }
    // 预处理出来跳过 第i个检查点 后的总距离
    int max = 0;
    int idx = 2;
    for(int i=2;i<=n-1;i++)
    {
        // 跳
        int sub = abs(a[i-1].first - a[i+1].first) + abs(a[i-1].second - a[i+1].second);
        // 不跳
        int no = abs(a[i-1].first - a[i].first) + abs(a[i-1].second - a[i].second)
        + abs(a[i].first - a[i+1].first) + abs(a[i].second - a[i+1].second);
        if(abs(no-sub) > max)
        {
            max = abs(no - sub);
            idx = i;
        }
    }
    printf("%d",sum-max);

    return 0;
}