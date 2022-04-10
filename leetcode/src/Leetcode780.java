/**
 * @author Csy
 * @Classname _780到达终点
 * @date 2022-04-09 20:26
 * @Description TODO
 */
public class Leetcode780 {

    public static void main(String[] args) {
        Solution780 s = new Solution780();
        s.reachingPoints(1,1,3,3);
    }
}

class Solution780 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 深度优先搜索 吗
        return dfs(sx,sy,tx,ty);
    }

    public boolean dfs(int sx,int sy,int tx,int ty){
        if(sx > tx || sy > ty)return false;
        if(sx == tx && sy == ty){
            return true;
        }
        int stepX = sx,stepY = sy;
        return dfs(sx+stepX,sy,tx,ty) || dfs(sx,sy+stepY,tx,ty);

    }
}
