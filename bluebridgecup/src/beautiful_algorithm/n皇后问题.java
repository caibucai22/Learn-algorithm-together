package beautiful_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname n皇后问题
 * @date 2022-03-24 10:53
 * @Description TODO
 */
public class n皇后问题 {

    // 较小的时候可以用一个全排列，来枚举每一quuen 的位置
    // 得到n个queen的位置后，然后进行判断 如 n=4,一共4*4*4*4种状态

    public static void main(String[] args) {
        int n = 6;
        int i = new Solution().nQuuen(n);
        System.out.printf("%d", i);
    }

}

class Solution{

    int ret = 0;

    List<List<String>> all = new ArrayList<>();

    public int nQuuen(int n){
        int[] rec = new int[n]; // idx 代表某一行 值代表某一列
        dfs(rec,0);
        return ret;
    }


    public void dfs(int[] rec,int row){
        if(row == rec.length){
            ret++;

            List<String> state = new ArrayList<>();
            for(int i:rec){ // 每一行
                System.out.print(i+" ");
                String r = "";
                for(int col=0;col<rec.length;col++){

                    if(col == i)r = r+"Q";
                    else{
                        r = r+".";
                    }
                }
                state.add(r);
//                System.out.println(r);
            }
            all.add(state);
//            System.out.println(">>>>>>>>>>>>>>>>>>>");
            System.out.println();
            return;
        }
        for(int col=0;col<rec.length;col++){ // 遍历确定这一行 列的位置

            if(check(rec,row,col)){
                rec[row] = col;
                dfs(rec,row+1);
                rec[row] = 0;

                // 这里的回溯可做 可不做 原因？？？
                /**
                 * 下一次的dfs依旧会改变同一行的值，所以不用回溯
                 *
                 * 回溯不回朔 不影响ret的值
                 */

            }

        }
    }

    // 剪枝 通过预判接下来位置放置后的状态是否冲突，来决定是否继续往下走
    public boolean check(int[] rec,int x,int y){
        for(int i=0;i<x;i++){ // 这里是 i<x 不是 i<n 检查之前的行 不是检查所有的行
            // 检查是否同列
            if(rec[i] == y)return false;
            // 检查是否同行 （这里用一维数组每一个i都是不同行，所以不需要）

            // 检查对角线
            // 主
            if(i+rec[i] == x+y)return false;
            // 副
            if(i-rec[i] == x-y)return false;
        }

        return true;
    }

}

