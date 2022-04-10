package day13;

import Utils.Util;

import java.util.ArrayList;

/**
 * @author Csy
 * @Classname _02_基数排序
 * @date 2022-01-31 10:57
 * @Description TODO
 */
public class _02_基数排序 {

    /**
     * 是桶排序的一个特例，通过分配和收集进行排序
     * 根据每一位上的数进行收集
     * 时间复杂度 是 k*n k是数字的最大位数
     * 基数排序无法对负数和0进行排序，
     * 对于负数处理 方式 增加 -1 。。。 -9 或者加上一个数变为正数 再进行排序
     * 下面测试数据均为正数
     *
     * @param args
     */

    private static ArrayList<Integer>[] bucket = new ArrayList[10];

    static {
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
//        int[] arr = {21,33,20,34,75,90,10,100,1,77};

        int[] arr = Util.getRandomArrWithoutRepeat(0,1000,10);
        sort(arr);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }

    public static void sort(int[] arr) {

        // 得到数据的最大值，
        int maxValue = Util.getMaxValueOfArr(arr);

        // 数据的最大位数
        int maxD = String.valueOf(maxValue).length();

        // 按照数位进行收集

        // 位数不一致的数进行排序

        for (int d = 1; d <= maxD; d++) {
            for (int i = 0; i < arr.length; i++) {
                int len = String.valueOf(arr[i]).length();
                if (d <= len) {

                    bucket[Util.getDigitsOn(arr[i], d)].add(arr[i]);
                }else{
                    bucket[0].add(arr[i]);
                }
            }
            // 收集完后 按新顺序重新恢复到数组
            int cur = 0;
            for(ArrayList<Integer> nums : bucket){
                for(int num : nums){
                    arr[cur++] = num;
                }
                nums.clear();
            }
            // 清空所有 bucket

        }
    }
}
