package day04;

/**
 * @author Csy
 * @Classname _07_汉诺塔
 * @date 2022-01-22 10:27
 * @Description TODO
 */
public class _07_汉诺塔 {

    public static void main(String[] args) {

        hano(3,"A","B","C");
    }

    static void hano(int n,String from,String to,String help){
        if(n==1){
            System.out.println("move "+n+" from "+from+" to "+to);
            return;
        }

        hano(n-1,from,help,to);
        System.out.println("move "+n+" from "+from+" to "+to);
        hano(n-1,help,to,from);
    }

    /**
     * 每个柱子角色的转换
     */
}
