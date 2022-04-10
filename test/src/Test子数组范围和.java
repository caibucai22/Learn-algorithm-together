import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Csy
 * @Classname Test子数组范围和
 * @date 2022-03-26 18:55
 * @Description TODO
 */
public class Test子数组范围和 {


    public static void main(String[] args) {
        int[] test = {4,-2,-3,4,1};
        long l = new Solution3().subArrayRanges(test);
        System.out.println(l);
    }

}

class Solution3 {
    public long subArrayRanges(int[] nums) {
        // 用两个队列维持最大值最小值
        long ret = 0;
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        // 两层循环枚举所有子数组
        for(int i=0;i<nums.length;i++){


            for(int j=i;j<nums.length;j++){

                //单调递增队列 队首是最小值
                while(!min.isEmpty() && nums[j] <= nums[min.peekLast()]){
                    min.pollLast();
                }
                // 单调递减队列 队首是最大值
                while(!max.isEmpty() && nums[j] >= nums[max.peekLast()]){
                    max.pollLast();
                }

                min.offerLast(j);
                max.offerLast(j);

                ret += (nums[max.peekFirst()] - nums[min.peekFirst()]);

            }
            // // 每次要清空
            while(!min.isEmpty())min.pollFirst();
            while(!max.isEmpty())max.pollFirst();


        }
        return ret;
    }
}
