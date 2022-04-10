package competition.sheng._2019;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Csy
 * @Classname Main2_2
 * @date 2022-03-23 17:39
 * @Description TODO
 */
public class Main2_2 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        String s = "0100110001010001";

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String sub = s.substring(i,j);
                set.add(sub);
            }
        }
        System.out.println(set.size());



    }

}
