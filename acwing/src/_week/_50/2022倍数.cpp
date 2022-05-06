#include<bits/stdc++.h>

using namespace std;
const int N = 1010;
// 二进制乘法
int a[N];


int main()
{
    string str;
    cin>>str;
    reverse(str.begin(),str.end());
    string mul = "10001"; // 前后对称所以翻不翻转都可以
    reverse(mul.begin(),mul.end());

    // 乘法
    for(int i=0;i<mul.length();i++){
        for(int j=0;j<str.length();j++){
            a[i+j] += (mul[i]-'0')*(str[j]-'0');
        }
    }
    // 处理进位
    for(int j=0;j<mul.length()+str.length();j++){
        a[j+1] += a[j]/2;
        a[j] = a[j]%2;
    }

    // 去除前导0
    int len = mul.length()+str.length();
    for(int i=len-1;i>=0;i--){
        if(a[i]==0)len--;
        else break;
    }
    for(int i=len-1;i>=0;i--)cout<<a[i];

    return 0;
}