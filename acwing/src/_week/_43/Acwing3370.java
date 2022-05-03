package _week._43;

import java.util.Scanner;

/**
 * @author Csy
 * @Classname _week._43.Acwing3370
 * @date 2022-03-15 23:10
 * @Description TODO
 */
public class Acwing3370 {

    static String[] years = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        // 如何存储 每个人 与其他人之间的距离
        pAndp[] ps = new pAndp[n];
        // 数据范围 1-100

        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            String name1 = strs[0],nexOrPre = strs[3],year = strs[4],name2 = strs[7];
            pAndp p = new pAndp(name1,name2);
            if("next".equals(nexOrPre)){
//                int dis = getDis()
            }else if("previous".equals(nexOrPre)){

            }

        }

    }

    public static int getDis(String year1,String year2){
        int idx1 = -1,idx2 = -1;
        for(int i=0;i<12;i++){
            if(years[i].equals(year1)){
                idx1 = i+1;
            }
            if(years[i].equals(year2)){
                idx2 = i+1;
            }
        }
        return idx1-idx2;
    }

}

class pAndp{
    String name1;
    String name2;
    int dis;

    public pAndp(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getDis() {
        return dis;
    }

    public void setDis(int dis) {
        this.dis = dis;
    }
}
