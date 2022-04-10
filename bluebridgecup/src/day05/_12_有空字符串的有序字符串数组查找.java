package day05;

import java.lang.annotation.Target;

/**
 * @author Csy
 * @Classname _12_有空字符串的有序字符串数组查找
 * @date 2022-01-23 10:30
 * @Description TODO
 */
public class _12_有空字符串的有序字符串数组查找 {

    public static void main(String[] args) {

        String[] arr = {"a", "", "ab", "", "bc", "", "c", ""};
        int ret = indexOf(arr, "abc");
        System.out.println(ret);
    }

    private static int indexOf(String[] arr, String target) {

        int begin = 0;
        int end = arr.length - 1;

        while (begin < end) {
            int mid = begin + (end - begin) >> 1;
            while ("".equals(arr[mid])) {
                mid++;

                // 超过 end 就找不到
                if (mid > end) {
                    return -1;
                }

                // mid 和 begin 在一块 mid跳不出去
                /**
                 * 是个问题
                 */


            }
            if (arr[mid].compareTo(target) > 0) {
                end = mid;
            } else if (arr[mid].compareTo(target) < 0) {
                begin = mid;
            } else {
                return mid;
            }

        }
        return -1;

    }
}
