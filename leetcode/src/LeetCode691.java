import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode691
 * @date 2022-05-14 21:18
 * @Description TODO
 */
public class LeetCode691 {

    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        Solution691 s = new Solution691();
        int i = s.minStickers(stickers, target);
    }

}

class Solution691 {

    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] memo = new int[1 << m];
        Arrays.fill(memo, -1);
        // 记录处理某一个子序列mask所需的最小贴纸数量
        memo[0] = 0;
        // 利用备忘录，自顶而下来进行搜索
        int ans = dp(stickers, target, memo, (1 << m) - 1);
        return ans > m ? -1 : ans;
    }

    /**
     * 用mask来表示target子序列，从低位到高位，0表示不选这个位置的字符，1表示选择
     */
    private int dp(String[] stickers, String target, int[] memo, int mask) {
        int m = target.length();
        // mask = 0 时停止搜索
        if (memo[mask] < 0) {
            int res = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                // 记录sticker每个字符出现的次数
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 /* 第i位是1，表示当前子序列包含这个字符 */
                            && cnt[c - 'a'] > 0 /* sticker中还剩余可选择的对应字符 */) {
                        cnt[c - 'a']--;
                        // 计算当前子序列剩余还未处理的字符
                        left ^= 1 << i;
                    }
                }
                // 本次sticker与mask存在交集才进行下一次dp
                if (left < mask) {
                    res = Math.min(res, dp(stickers, target, memo, left) + 1 /* +1 意思是包含本次处理的sticker */);
                }
            }
            memo[mask] = res;
        }
        return memo[mask];
    }
}