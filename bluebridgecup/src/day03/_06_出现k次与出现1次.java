package day03;

/**
 * @author Csy
 * @Classname _06_出现k次与出现1次
 * @date 2022-01-21 19:16
 * @Description 输出只出现了1次的数
 */
public class _06_出现k次与出现1次 {

    public static void main(String[] args) {

        // 任意进制转换的方法
        // 手动转换
//        Integer.toString()

        int[] arr = {1, 1, 1, 2, 2, 2, 3, 4, 4, 4};
        int k = 3;
        int len = arr.length;

        char[][] kRadix = new char[len][];

        // 转换成k进制的字符数组
        int maxLen = 0;
        for (int i = 0; i < len; i++) {

            // 求每个数字的三进制字符串并翻转，然后转换为字符数组


            // 翻转是为了对齐每一位

            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }

        int[] resArr = new int[maxLen];

        // 进行不进位加法
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < maxLen; j++) {

                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }

        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i] % k) * (int) (Math.pow(k, i));
        }

        System.out.println(res);
    }
}
