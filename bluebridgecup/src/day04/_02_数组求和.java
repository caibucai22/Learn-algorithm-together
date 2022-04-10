package day04;

/**
 * @author Csy
 * @Classname _02_数组求和
 * @date 2022-01-22 9:53
 * @Description TODO
 */
public class _02_数组求和 {

    public static void main(String[] args) {

    }


    static int f(int[] arr,int begin){

        // 递归边界
        if(begin == arr.length-1){
            return arr[begin];
        }
        // 剩余部分 重复子问题

        return arr[begin] + f(arr,begin+1);

    }
}
