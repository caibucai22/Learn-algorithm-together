import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode2055
 * @date 2022-03-08 18:37
 * @Description TODO
 */
public class LeetCode2055 {


    public static void main(String[] args) {

        String str = "***|**|*****|**||**|*";
        int[][] b = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        int[] ret = platesBetweenCandles(str, b);

        for (int i : ret) {
            System.out.printf("%d ", i);
        }
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        // 分析数据范围 1-10^5 ，10^5 最大10^10
        int n = queries.length;
        int[] ret = new int[n];
        char[] chs = s.toCharArray();
        int idx = 0;

        int[] preFix = new int[s.length()]; // 表示截止到i（包括i）有多少个盘子
        List<Integer> candix = new ArrayList<>();
        int ldx = -1;
        preFix[0] = chs[0] == '*' ? 1 : 0;

        // 特例
        if(chs[0] == '|'){
            candix.add(0);
        }

        for(int i=1;i<s.length();i++){
            if(chs[i] == '*'){
                preFix[i] = preFix[i-1]+1;

            }else{
                preFix[i] = preFix[i-1];
                candix.add(i); // 把蜡烛的位置也预处理出来
            }
        }

        int cnt = 0;
        for(int[] range : queries){
            int l = range[0],r = range[1];

            System.out.println(cnt++);

            int lcandle = binarySearchL(candix,l);
            int rcandle = binarySearchR(candix,r);


            // 优化成
            ret[idx++] = preFix[rcandle]-preFix[lcandle];
        }
        return ret;
    }


    public static int binarySearchL(List<Integer> candix,int tagret){
        int l = -1,r = candix.size();

        while(l+1 != r){
            int mid = l + ((r-l)>>1);
            int midVal = candix.get(mid);

            // 将数组划分为 小于  和 大于 等于 的部分 然后返回 r
            if(tagret > midVal){
                l = mid;
            }else{
                r = mid;
            }
        }
        return r;
    }

    public static int binarySearchR(List<Integer> candix,int tagret){
        int l = -1,r = candix.size();

        while(l+1 != r){
            int mid = l + ((r-l)>>1);
            int midVal = candix.get(mid);

            // 将数组划分为 小于等于  和 大于  的部分 然后返回 l
            if(tagret < midVal){
                r = mid;
            }else{
                l = mid;
            }
        }
        return l;
    }

//    public static int[] platesBetweenCandles(String s, int[][] queries) {
//        // 分析数据范围 1-10^5 ，10^5 最大10^10
//        int n = queries.length;
//        int[] ret = new int[n];
//        char[] chs = s.toCharArray();
//        int idx = 0;
//
//        int[] preFix = new int[s.length()];
//        List<Integer> candix = new ArrayList<>();
//        int ldx = -1;
//        preFix[0] = chs[0] == '*' ? 1 : 0;
//
//        // 特例
//        if (chs[0] == '|') {
//            candix.add(0);
//        }
//
//        for (int i = 1; i < s.length(); i++) {
//            if (chs[i] == '*') {
//                preFix[i] = preFix[i - 1] + 1;
//
//            } else {
//                preFix[i] = preFix[i - 1];
//                candix.add(i); // 把蜡烛的位置也预处理出来
//            }
//        }
//
//
//        for (int[] range : queries) {
//            int l = range[0], r = range[1];
//            int cnt = 0;
//            // 这里使用双指针进行查找边界 进一步优化为二分查找
//            // 二分查找需要排序 !!! 蜡烛的位置是递增的
//
//            // 折半查找 离所给边界最近的蜡烛
//            int ll = 0, rr = candix.size() - 1;
//            int lcandle = -1, rcandle = -1;
//            boolean isUpdate = false;
//            while (ll <= rr) {
//                int mid = ll + ((rr - ll) >> 1);
//                if (candix.get(mid) == l) {
//                    lcandle = candix.get(mid);
//                    isUpdate = true;
//                    break;
//                } else if (candix.get(mid) > l) {
//                    rr = mid - 1;
//                } else if (candix.get(mid) < l) {
//                    ll = mid + 1;
//                }
//            }
//            if (!isUpdate) {
//                lcandle = ll;
//            }
//
//            ll = 0;
//            rr = candix.size() - 1;
//            isUpdate = false;
//            while (ll <= rr) {
//                int mid = ll + ((rr - ll) >> 1);
//                if (candix.get(mid) == r) {
//                    rcandle = candix.get(mid);
//                    isUpdate = true;
//                    break;
//                } else if (candix.get(mid) > r) {
//                    rr = mid - 1;
//                } else if (candix.get(mid) < r) {
//                    ll = mid + 1;
//                }
//            }
//            if (!isUpdate) {
//                rcandle = ll;
//            }
//
//
//            // 两个指针左右逼近
//            // while(l<r && chs[l] != '|') {
//            //     l++;
//            // }
//            // while(l<r && chs[r] != '|'){
//            //     r--;
//            // }
//
//            // for(int i = l;i<r;i++){ // 这里进行优化 可以使用前缀和 储存到每个位置的 盘子数
//            //     if(chs[i] == '*'){
//            //         cnt++;
//            //     }
//            // }
//
//            // ret[idx++] = cnt;
//
//            // 优化成
//            ret[idx++] = preFix[rcandle] - preFix[lcandle];
//        }
//        return ret;
//        // 以上是暴力解法 n^2 超时
//    }
}
