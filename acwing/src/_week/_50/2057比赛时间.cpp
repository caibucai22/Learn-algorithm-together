#include<bits/stdc++.h>

using namespace std;

int main()
{
    int a,b,c;
    cin>>a>>b>>c;
    if((a<=11&&b<11)||(a<=11&&b<=11&&c<11))cout<<-1;//结束时间比开始时间还早
    else cout<<(a-11)*1440+(b-11)*60+c-11;//先算一下日期、小时和分钟与11的差值，再全部转化单位为分钟即可
}