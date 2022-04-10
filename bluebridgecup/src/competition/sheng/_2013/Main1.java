package competition.sheng._2013;

import java.util.Calendar;

/**
 * @author Csy
 * @Classname Main1
 * @date 2022-03-21 16:40
 * @Description TODO
 */
public class Main1 {

    // 世纪末的星期
    // 答案：2199
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        for(int i=1999;;i += 100){
            calendar.set(i,12,31);
            int idx =  calendar.get(Calendar.DAY_OF_WEEK);
            if(idx == 6){
                System.out.println(i);
                break;
            }
        }

    }
}
