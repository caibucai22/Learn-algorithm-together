import org.junit.Test;

/**
 * @author Csy
 * @Classname Test阶乘后的零
 * @date 2022-03-25 8:57
 * @Description TODO
 */
public class Test阶乘后的零 {


    public int trailingZeroes(int n) {
        // 一般思路 算出阶乘后的数，然后判断0的个数
        int ret = 0;
        long a = 1;
        for(int i=1;i<=n;i++){
            a *= i;
        }

        String str = String.valueOf(a);
        char[] chs = str.toCharArray();
        for(int i=chs.length-1;i>=0;i--){
            if(chs[i] == '0'){
                ret++;
            }else{
                break;
            }
        }
        return ret;
    }


    @Test
    public void test01(){
        int i = trailingZeroes(13);
        System.out.printf("%d", i);
    }

}



