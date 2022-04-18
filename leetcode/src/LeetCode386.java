import java.util.ArrayList;
import java.util.List;

/**
 * @author Csy
 * @Classname LeetCode386
 * @date 2022-04-18 20:04
 * @Description TODO
 */
public class LeetCode386 {

    public static void main(String[] args) {

    }

}

class Solution386 {

    int N = 100010;
    int[][] tree = new int[N][10];
    boolean[] end = new boolean[N];
    int total = 0;

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i=1;i<=n;i++)insert(i);
        dfs(0,"",ret);
        return ret;
    }


    private void insert(int n){
        char[] chs = String.valueOf(n).toCharArray();
        int len = chs.length;
        int root = 0;
        for(int i=0;i<len;i++){
            int idx = chs[i]-'0';
            if(tree[root][idx] == 0)tree[root][idx] = ++total;
            root = tree[root][idx];
        }
        end[root] = true;
    }

    private void dfs(int u,String path,List<Integer> ret){
        if(u != 0){
            ret.add(Integer.valueOf(path));
        }
        for(int i=0;i<10;i++){
            if(tree[u][i] == 0)continue;
            dfs(tree[u][i],path+(char)(i+'0'),ret);
        }
    }
}

// 这样写 由于服务器上只有一个solution tree[][] 不能是全局的 去掉static
