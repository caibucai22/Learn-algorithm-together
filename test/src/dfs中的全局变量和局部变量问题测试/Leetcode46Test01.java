package dfs中的全局变量和局部变量问题测试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname Test01
 * @date 2022-03-23 14:56
 * @Description TODO
 */
public class Leetcode46Test01 {

    public static void main(String[] args) {
        // 使用全局变量
        int[] test = {1,2,3};
        new Solution1().permute(test);
    }

}

class Solution1 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        boolean[] flag = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfs(nums, flag, path);


        for (List<Integer> p : ret) {
            System.out.printf("{");
            for (int i : p) {
                System.out.printf("%d ", i);
            }
            System.out.printf("}");
        }
        System.out.println();

        return ret;
    }

    public void dfs(int[] nums, boolean[] flag, List<Integer> path) {
        //


        if (path.size() == nums.length) {

//            for(int i :path){
//                System.out.printf("%d ", i);
//            }
//            System.out.println();

            ret.add(new ArrayList(path));
            return;
        }



        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {

                flag[i] = true;
                path.add(nums[i]);
                dfs(nums, flag, path);
                // 撤销
                flag[i] = false;
                path.remove(path.size() - 1);
            }

        }
    }

    public boolean isAllUse(boolean[] flag) {
        for (boolean b : flag) {
            if (b == false) {
                return false;
            }
        }
        return true;
    }
}
