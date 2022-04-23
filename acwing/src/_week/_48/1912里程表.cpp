#include <bits/stdc++.h>
using namespace std;
long long x, y, ans = 0;

// 逆向思维
int main() {
    cin >> x >> y;
    for (int i = 3; i <= 17; i++) {     //数字长度
        for (int j = 0; j <= 9; j++) {  //相同的数字
            string str(i, '0' + j);     //先构造一个全部相同的数字
            for (int k = 0; k <= 9; k++) { //新数字k
                if (j == k) continue;   //判重
                for (int o = 0; o < i; o++) {
                    str[o] = '0' + k;   //加入“错误字符”
                    long long p = 0;
                    for (int q = 0; q < i; q++) p = p * 10 + (str[q] - '0');
                    if (str[0] != '0' && x <= p && p <= y) ans++;
                    str[o] = '0' + j;   //一定要记住还原现场，当时就被坑了……
                }
            }
        }
    }
    printf("%lld\n", ans);
    return 0;
}