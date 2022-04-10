package highAccuracy;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname 高精度减法
 * @date 2022-03-09 16:28
 * @Description TODO
 */
public class 高精度减法 {


    // 高精度减法

    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String a = sc.nextLine();
        String b = sc.nextLine();

        // 逆序存储
        for(int i=a.length()-1;i>=0;i--)A.add(a.charAt(i)-'0');
        for(int i=b.length()-1;i>=0;i--)B.add(b.charAt(i)-'0');


        List<Integer> C = new ArrayList<>();

        if(cmp(A,B)){
            C = sub(A,B);
        }else{
            C = sub(B,A);
            System.out.print("-");
        }
        // 逆序输出
        for(int i = C.size()-1;i>=0;i--){
            System.out.print(C.get(i));
        }
    }

    // 判断 a >= b

    public static boolean cmp(List<Integer> A,List<Integer> B){
        if(A.size() != B.size()){
            return A.size() >= B.size();
        }
        for(int i = A.size()-1;i>=0;i--){
            if(A.get(i).equals(B.get(i))){
                return A.get(i) >= B.get(i);
            }
        }
        // 跳出循环 完全相等 为 true
        return true;
    }

    public static List<Integer> sub(List<Integer> A,List<Integer> B){
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for(int i=0;i<A.size();i++){
            t = A.get(i) - t;
            if(i < B.size())t = t - B.get(i);
            C.add((t+10)%10);

            // 判断借位
            if(t < 0){
                t = 1;
            }else{
                t = 0;
            }
        }
        while(C.size() > 1 && C.get(C.size()-1)==0)C.remove(C.size()-1);

        return C;
    }


    public static BigDecimal sub2(BigDecimal a,BigDecimal b){
        return a.subtract(b);
    }
}
