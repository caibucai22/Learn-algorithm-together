package day10;

import java.util.Arrays;

import static day07._07_第k个小的数.selectK;

/**
 * @author Csy
 * @Classname _10_超过一半的数
 * @date 2022-01-28 19:25
 * @Description TODO
 */
public class _10_超过一半的数 {


    public static void main(String[] args) {


//        解法1 排序后返回 arr[n/2] nlgn
//        hash统计
//        顺序统计
//        不同的数，进行消除
    }

    static int solve1(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    static int solve3(int[] arr){
        int res = selectK(arr,0,arr.length-1,arr.length/2);
        return res;
    }

    // 两两消除
}
