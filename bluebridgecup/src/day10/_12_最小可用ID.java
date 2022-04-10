package day10;

import java.util.Arrays;

import static day07._07_第k个小的数.selectK;

/**
 * @author Csy
 * @Classname _12_最小可用ID
 * @date 2022-01-28 20:09
 * @Description TODO
 */
public class _12_最小可用ID {

    public static void main(String[] args) {

        // 缺席的最小数
        // 乱序

        // 测试数据从 0开始


//        思路1，排序后，判断其是否在 对应的位置上
//        解法2，hash统计，然后扫描hash数组，发现不存在的
//        解法3，

    }

    static int find1(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
            i++;
        }
        return i + 1;
    }

    static void find3(int[] arr) {
        int[] hash = new int[arr.length + 1];
        for (int i : arr) {

            // 防止出现大于 数组长度的数，导致数组越界 如 数组长度10，数为11
            if (i < arr.length + 1) {
                hash[i]++;
            }

        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                System.out.println(i);
            }
        }
    }

    static int find4(int[] arr, int l, int r) {
        if (l > r) {
            return l + 1;
        }
        int midIndex = l + ((r - l) >> 1);
        int q = selectK(arr, l, r, midIndex - l + 1);
        int t = midIndex + 1;
        if (q == t) {
            return find4(arr, midIndex + 1, r);
        } else {
            return find4(arr, l, midIndex - 1);
        }
    }
}
