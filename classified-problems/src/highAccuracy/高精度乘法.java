package highAccuracy;

/**
 * @author Csy
 * @Classname 高精度乘法
 * @date 2022-03-31 16:47
 * @Description TODO
 */
public class 高精度乘法 {

    public static void main(String[] args) {
        String a = "123",b = "456";
        String mul = multiply(a, b);
        System.out.printf("%s", mul);
    }

    public static String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2))return "0"; // 存在0的情况进行特判
        int m = num1.length(),n = num2.length();
        int[] a = new int[m];
        int[] b = new int[n];
        int idx = 0;

        // 预处理出两个翻转的int数组
        for(int i=m-1;i>=0;i--){
            a[idx++] = num1.charAt(i)-'0';
        }
        idx = 0;
        for(int i=n-1;i>=0;i--){
            b[idx++] = num2.charAt(i)-'0';
        }

        return mul(a,b);
    }

    // a*b
    private static String mul(int[] a,int[] b){
        int m = a.length,n = b.length;
        int[] ret = new int[m+n];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ret[i+j] += a[i]*b[j];
            }
        }
        // 处理进位
        for(int i=0;i+1<m+n;i++){
            ret[i+1] += ret[i]/10;
            ret[i] = ret[i]%10;
        }
        int len = m+n;
        // 去除前导0
        for(int i=m+n-1;i>=0;i--){
            if(ret[i] == 0){
                len--;
            }else{
                break;
            }
        }
        for(int i=len-1;i>=0;i--){
            sb.append(ret[i]);
        }
        return sb.toString();
    }

}
