package leetcode;

/**
 * @author Csy
 * @Classname Test数组中两个数的最大异或值
 * @date 2022-04-03 15:25
 * @Description TODO
 * 00101
 * 11001
 */
public class Test数组中两个数的最大异或值 {

    public static void main(String[] args) {
        int[] test = {5, 25};
        Solution421 s = new Solution421();
        int xor = s.findMaximumXOR(test);
        System.out.println(xor);
    }

}

class Solution421 {
    // 数组版trie
    static final int N = 100; // 最多30层
    static int[][] tree = new int[N][2];
    static int total;

    private void insert(int num) {
        int root = 0;
        String str = Integer.toBinaryString(num); // 转换成二进制
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - '0';
            if (tree[root][idx] == 0) tree[root][idx] = ++total;
            root = tree[root][idx];
        }
    }

    private int check(int num) {
        int cur = 0; //从根出发
        int x = 0;  //存放结果
        char[] chs = Integer.toBinaryString(num).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - '0';
            if (idx == 0) {
                if (tree[cur][1] != 0) {
                    cur = tree[cur][1];
                    x = x * 2 + 1;
                } else {
                    cur = tree[cur][0]; // 正常就是走这里 肯定不为空
                    x = x * 2;
                }
            } else {
                // idx == 1;
                if (tree[cur][0] != 0) {
                    cur = tree[cur][0];
                    x = x * 2 + 1;
                } else {
                    cur = tree[cur][1];
                    x = x * 2;
                }
            }
        }
        return x;
    }


    public int findMaximumXOR(int[] nums) {
        // 建树
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            x = Math.max(x, check(nums[i]));
        }
        // 两个for循环也可以合并为1个 见官方解答

        return x;
    }


    // 暴力
    public int findMaximumXOR1(int[] nums) {
        int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ret = Math.max(ret, nums[i] ^ nums[j]);
            }
        }
        return ret;
    }
}

class Solution {
    // 数组版trie
    static final int N = 100; // 最多30层
    static int[][] tree = new int[N][2];
    static int total;


    private String fix(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    private void insert(int num) {
        int root = 0;
        String str = Integer.toBinaryString(num); // 转换成二进制
        str = fix(32 - str.length()) + str; // 补0
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - '0';
            if (tree[root][idx] == 0) tree[root][idx] = ++total;
            root = tree[root][idx];
        }
    }

    private int check(int num) {
        int cur = 0; //从根出发
        int x = 0;  //存放结果
        String str = Integer.toBinaryString(num);
        str = fix(32 - str.length()) + str;
        char[] chs = str.toCharArray(); // 转换成字符串的做法是不对的，高位为0的情况没有参与
        // 修改后 就是全部补成32位数 缺多少位 在前面加多少位的0 使用fix函数在前面补0
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - '0';
            if (idx == 0) {
                if (tree[cur][1] != 0) {
                    cur = tree[cur][1];
                    x = x * 2 + 1;
                } else {
                    cur = tree[cur][0]; // 正常就是走这里 肯定不为空
                    x = x * 2;
                }
            } else {
                // idx == 1;
                if (tree[cur][0] != 0) {
                    cur = tree[cur][0];
                    x = x * 2 + 1;
                } else {
                    cur = tree[cur][1];
                    x = x * 2;
                }

            }
        }
        return x;
    }

    public int findMaximumXOR(int[] nums) {
        // 建树
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            x = Math.max(x, check(nums[i]));
        }
        // 两个for循环也可以合并为1个 见官方解答

        return x;
    }

}

