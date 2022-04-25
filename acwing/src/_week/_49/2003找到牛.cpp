#include<bits/stdc++.h>

using namespace std;
const int N = 50010;
string s;

// 最优解
int main()
{
    cin >> s;
    int n = s.length();
    int cnt = 0,back= 0;
    for(int i=1;i<n;i++)
    {
        if((s[i-1]=='(' && s[i]=='('))back++;
        if(s[i]==')' && s[i-1] == ')')cnt += back;

    }
    cout<<cnt<<endl;
    return 0;
}