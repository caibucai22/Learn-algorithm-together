import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode905
 * @date 2022-04-28 13:20
 * @Description TODO 按奇偶数组排序 （不要求具体顺序 分开就好）
 */
public class LeetCode905 {

    public static void main(String[] args) {
        Solution905 s = new Solution905();
        int[] test1 = {1,2,3,4,5,6,7,8,9};
        int[] test2 = {1,2,3,4,5,6,7,8,9};
        s.sortArrayByParity1(test1);
        s.sortArrayByParity2(test2);

        Arrays.stream(test1).forEach(o -> System.out.print(o+" "));

        System.out.println();

        Arrays.stream(test2).forEach(o -> System.out.print(o+" "));

    }

}

class Solution905 {

    // 从两边同时遍历 代码结构更好
    public int[] sortArrayByParity1(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left<right){
            while(left<right && nums[left]%2==0) left++;
            while(left<right && nums[right]%2==1) right--;
            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    // 从左边同时遍历
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        for(int i=0,j=0;j<n;){
            if(nums[j]%2 != 0){
                i = j+1; // 保证是从j后面找 [0,1] 这种情况会出现 j在i前面
                while(i<n && nums[i]%2 != 0)
                {
                    i++;
                }
                // i超过数组范围就直接break，找不到偶数了
                if(i < n){
                    swap(nums,i,j);
                }else{
                    break;
                }

                // j++;
            }
            // else{
            //     j++;
            // }

            j++; //与注释效果等价
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}