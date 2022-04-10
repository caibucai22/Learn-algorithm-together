package _04;

/**
 * @author Csy
 * @Classname Test01
 * @date 2022-03-02 15:05
 * @Description TODO
 */
public class Test01 {

    public static void main(String[] args) {
        String num = "11011";
        int n = num.length();
        int splitLen = n % 2 == 0 ? n / 2 : n / 2 + 1;
        String tmpSub = num.substring(0, splitLen);
        // 由于 一半num长度 为 9  int 能装下
        String sub_ = "", subAdd = "", subRed = "";
        if (n % 2 == 0) {
            sub_ = tmpSub + new StringBuilder(tmpSub).reverse().toString();

            String tmpSubAdd = tmpSub.substring(0, splitLen - 1) + (Integer.parseInt(tmpSub.substring(splitLen - 1, splitLen)) + 1);
            subAdd = tmpSubAdd + new StringBuilder(tmpSubAdd).reverse().toString();

            String tmpSubRed = tmpSub.substring(0, splitLen - 1) + (Integer.parseInt(tmpSub.substring(splitLen - 1, splitLen)) - 1);
            subRed = tmpSubRed + new StringBuilder(tmpSubRed).reverse().toString();

            System.out.println("sub_ = "+sub_+" subAdd = "+subAdd+" subRed = "+subRed);
        } else {
            sub_ = tmpSub + new StringBuilder(tmpSub.substring(0, splitLen - 1)).reverse().toString();


            String tmpSubAdd = tmpSub.substring(0, splitLen - 1) + (Integer.parseInt(tmpSub.substring(splitLen - 1, splitLen)) + 1);
            subAdd = tmpSubAdd + new StringBuilder(tmpSubAdd.substring(0, splitLen - 1)).reverse().toString();


            String tmpSubRed = tmpSub.substring(0, splitLen - 1) + (Integer.parseInt(tmpSub.substring(splitLen - 1, splitLen)) - 1);
            subRed = tmpSubRed + new StringBuilder(tmpSubRed.substring(0, splitLen - 1)).reverse().toString();

            System.out.println("sub_ = "+sub_+" subAdd = "+subAdd+" subRed = "+subRed);

        }

        // 合并后最大 18 位 得用long
        long a = Math.abs(Long.parseLong(num) - Long.parseLong(sub_));
        long b = Math.abs(Long.parseLong(num) - Long.parseLong(subAdd));
        long c = Math.abs(Long.parseLong(num) - Long.parseLong(subRed));
        long min = Math.min(a,Math.min(b,c));
        System.out.println(a+" "+b+" "+" "+c+" "+min);
        // 衡量3个数到 num的距离 取最近者 如果有相同距离 取最小的那个数

        if(num.equals(sub_)){ // 此时sub_ 和 num 距离为0 排除掉
            min = Math.min(b,c);
            if(min == b && min == c ){
                System.out.println(subRed);
            }else if(min == c){
                System.out.println(subRed);
            }else if(min == b){
                System.out.println(subAdd);
            }
        }else{
            min = Math.min(a,Math.min(b,c));
            if(min == b && min == c ){
                System.out.println(subRed);
            }else if(min == c){
                System.out.println(subRed);
            }else if(min == b){
                System.out.println(subAdd);
            }else{
                System.out.println(sub_);
            }
        }

//        if(min == b && min == c ){
//            System.out.println(subRed);
//        }else if(min == c){
//            System.out.println(subRed);
//        }else if(min == b){
//            System.out.println(subAdd);
//        }
//        System.out.println(sub_);


//        if(min == a){
//            System.out.println(sub_);
//        }else if(min == b){
//            System.out.println(subAdd);
//        }else{
//            System.out.println(subRed);
//        }
    }
}
