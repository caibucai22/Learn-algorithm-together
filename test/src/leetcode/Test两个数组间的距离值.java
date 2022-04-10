package leetcode;

/**
 * @author Csy
 * @Classname Test两个数组间的距离值
 * @date 2022-03-30 14:16
 * @Description TODO
 */
public class Test两个数组间的距离值 {

    public static void main(String[] args) {

        Solution1385 s = new Solution1385();
        int[] a = {1,4,2,3};
        int[] b = {-4,-3,6,10,20,30};
        int d = 3;
        s.findTheDistanceValue(a,b,d);

    }

}


class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // nlgn 对arr2 进行排序 使得查找降低为 lgn
        // Arrays.sort(arr2);
        int ret = arr1.length;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;i++){
                int l = arr1[i]-d,r = arr1[i]+d;
                if(arr2[j] >= l && arr2[j] <= r){
                    ret--;
                    break;
                }
            }
        }
        return ret;
    }
}
