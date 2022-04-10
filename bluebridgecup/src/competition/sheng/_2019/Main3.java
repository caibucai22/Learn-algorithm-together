package competition.sheng._2019;

/**
 * @author Csy
 * @Classname Main3
 * @date 2022-03-23 17:45
 * @Description TODO
 */
public class Main3 {

    public static void main(String[] args) {

        int a=1,b=1,c=1,d =0;
        for(int i=4;i<= 20190324 ;i++){
            d = (a+b+c)%10000;
            a=b;
            b=c;
            c=d;
        }
        System.out.println(d%10000);

    }

}
