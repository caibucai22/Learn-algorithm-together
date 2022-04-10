package day10;

/**
 * @author Csy
 * @Classname _11_寻找水贴王
 * @date 2022-01-28 19:57
 * @Description TODO
 */
public class _11_寻找水贴王 {

    public static void main(String[] args) {



    }

    static void solve4(int[] arr){
        int candidate = arr[0];
        int nTimes = 1;

        for(int i=1;i<arr.length;i++){
            if(nTimes == 0){
                candidate = arr[i];
                nTimes = 1;
                continue;
            }

            if(arr[i] == candidate){
                nTimes++;
            }else{
                nTimes--;
            }
        }
        System.out.println(candidate);
    }
}
