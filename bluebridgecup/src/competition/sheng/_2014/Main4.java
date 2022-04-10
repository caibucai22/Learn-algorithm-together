package competition.sheng._2014;

/**
 * @author Csy
 * @Classname Main4
 * @date 2022-03-22 18:10
 * @Description TODO
 */
public class Main4 {

    public static void main(String[] args) {

        /**
         * 它的前几项是：0、2、4、8、12、18、24、32、40、50 ...
         *
         * 其规律是：对偶数项，是序号平方再除2，奇数项，是序号平方减1再除2。
         *
         * 以下的代码打印出了大衍数列的前 100 项。
         */

        for (int i = 1; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(i * i / 2);
            }else{
                System.out.println((i * i - 1) / 2);
            }
        }

    }

}
