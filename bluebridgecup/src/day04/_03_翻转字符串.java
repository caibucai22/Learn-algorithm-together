package day04;

/**
 * @author Csy
 * @Classname _03_翻转字符串
 * @date 2022-01-22 9:57
 * @Description TODO
 */
public class _03_翻转字符串 {

    public static void main(String[] args) {

    }


    static String reverse(String src,int end){

        // 递归边界/出口
        if(end == 0){
            return ""+src.charAt(0);
        }

        // 重复子问题
        return src.charAt(end) + reverse(src,end-1);

    }
}
