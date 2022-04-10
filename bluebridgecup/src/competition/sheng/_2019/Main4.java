package competition.sheng._2019;

/**
 * @author Csy
 * @Classname Main4
 * @date 2022-03-23 18:03
 * @Description TODO 在一些题中 想使用深度优先搜索 需要分析数据范围
 * 比如这道题 2019 这个就不太适合 1-2019  范围比较大 3层
 * （这题等价于路径之和，1-2019 遍历 剪枝条件 有 数字不包含2和4  还有根据求和关系 提前剪枝
 * 差不多数据规模少一半 2000的3次方 也可以做 注意去重
 */
public class Main4 {

    public static void main(String[] args) {

        int ret = 0;
        for(int i=1;i<2019;i++){
            for(int j=i+1;j<2019;j++){
                int k = 2019-i-j;
                if(check(i) || check(j) || check(k))continue;
                if(k>j)ret++; // 保障一个递增序列
            }
        }
        System.out.println(ret);

    }

    private static boolean check(int j) {
        char[] chs = String.valueOf(j).toCharArray();

        for(char ch : chs){
            if(ch=='2' || ch =='4'){
                return true;
            }
        }

        return false;
    }

}
