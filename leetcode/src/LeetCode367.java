/**
 * @author Csy
 * @Classname LeetCode367
 * @date 2021-11-04 18:31
 * @Description TODO
 */
public class LeetCode367 {
    public static boolean isPerfectSquare(int num) {
        // 又是二分法
        int L = 1,R = num;
        while(L<=R){
            int mid = L + (R-L)/2;
            int tmp = num/mid;
            if(tmp == mid){
                return true;
            }else if(tmp<mid){
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
}
