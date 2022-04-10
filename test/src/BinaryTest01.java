import org.junit.Test;

/**
 * @author Csy
 * @Classname BinaryTest01
 * @date 2022-03-28 12:00
 * @Description TODO
 */
public class BinaryTest01 {


    @Test
    public void test01() {

        int[] a = {1, 2, 2, 3, 3, 4};
        // 查找起始和结束下标
        int l = 0,r = a.length-1;
        int q = 2;
        // 数组分为 >= 2

        // 右边界
        while(l < r){
            int mid = l + (r - l >> 1);
            if(a[mid] >= q)r = mid;
            else{
                l = mid+1;
            }

            if(a[r] == q){
                System.out.printf("%d ",r);
                l = 0;r = a.length-1;

                // 左边界
                while(l < r){
                    int mid2 = l + (r-l >>1);
                    if(a[mid2] <= q)l = mid2;
                    else{
                        r = mid2-1;
                    }
                }
                System.out.printf("%d",r);
            }else{
                System.out.println("-1 -1");
            }
        }
    }


}
