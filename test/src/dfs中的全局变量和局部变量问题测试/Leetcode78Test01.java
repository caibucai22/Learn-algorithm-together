package dfs中的全局变量和局部变量问题测试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname Leetcode78Test01
 * @date 2022-03-23 15:19
 * @Description TODO
 */
public class Leetcode78Test01 {

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        new Solution01().subsets(test);
    }

}


class Solution01 {

    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return ret;
        }
        backTrack(nums, 0);
        return ret;
    }

    public void backTrack(int[] nums, int start) {

        System.out.println("path状态:");
        for (int i :path){
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println("ret状态:");

        for(List<Integer> l : ret){
            System.out.printf("{");
            for (int i :l){
                System.out.printf("%d ", i);
            }
            System.out.printf("}");
        }
        System.out.println();


        ret.add(new ArrayList(path));

        if (start == nums.length) {

            return;
        }

        //
        for (int i = start; i < nums.length; i++) {

            // 选择该节点
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);

        }
    }


}
