import java.util.Arrays;
import java.util.List;

/**
 * @author Csy
 * @Classname BSearchTest01
 * @date 2022-03-08 23:22
 * @Description TODO
 */
public class BSearchTest01 {

    public static void main(String[] args) {
        int[] test = {1,2,3,3,4,5,5,6,7,8, 9,10,10,11,12,12,12,13,14,14,15};
        //            0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        List<Integer> list = Arrays.asList(3,6,12,15,16,19);
        //                                 0 1 2  3  4  5

        int[][] b = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        // 第一个 >=
        int l = binarySearchL(list,14);
        // 最后一个 <=
        int r = binarySearchR(list, 17); //

        System.out.print(l+" "+r+" ");
        System.out.println("右边界"+list.get(r)+" 左边界"+list.get(l));
        System.out.println(test[list.get(r)]-test[list.get(l)]);

    }


    // 找第一个 >= 的数
    public static int binarySearchL(List<Integer> candix, int tagret){
        int l = -1,r = candix.size();

        while(l+1 != r){
            int mid = l + ((r-l)>>1);
//            int midVal = candix.get(mid);

            // 将数组划分为 小于  和 大于 等于 的部分 然后返回 r
            if(tagret > mid){
                l = mid;
            }else{
                r = mid;
            }
        }
        return r;
    }

    // 找最后一个 <= 的数
    public static int binarySearchR(List<Integer> candix,int tagret){
        int l = -1,r = candix.size();

        while(l+1 != r){
            int mid = l + ((r-l)>>1);
//            int midVal = candix.get(mid);

            // 将数组划分为 小于等于  和 大于  的部分 然后返回 l
            if(tagret < mid){
                r = mid;
            }else{
                l = mid;
            }
        }
        return l;
    }
}
