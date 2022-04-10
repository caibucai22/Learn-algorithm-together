import org.junit.Test;

import java.util.Calendar;

/**
 * @author Csy
 * @Classname DateTest01
 * @date 2022-03-07 15:30
 * @Description TODO
 */
public class DateTest01 {

    @Test
    public void test01() {
        // 具体到星期几
        Calendar c = Calendar.getInstance();
        c.set(2022, 2, 7);
        // 月份从 0开始 0-11 ,注意减 1
        int i = c.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(i);

        /**
         * 也可以使用 windows计算器 进行日期计算
         */
    }

    @Test
    public void test02(){
        // 日期的格式化

    }
}
