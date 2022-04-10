package competition.sheng._2013;

/**
 * @author Csy
 * @Classname Main6
 * @date 2022-03-21 18:41
 * @Description TODO
 */
public class Main6 {


    public static void main(String[] args) {

        int[] test = {5,4,3,2,1,0,1,0,-1,-2,-3};
        sort(test);

        for (int i : test) {
            System.out.printf("%d ", i);
        }
    }

    static void sort(int[] x)
    {
        int p = 0;
        int left = 0;
        int right = x.length-1;

        while(p<=right){
            if(x[p]<0){
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            }
            else if(x[p]>0){
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;
            }
            else{
                  //代码填空位置
                p++;
            }
        }
    }


}
