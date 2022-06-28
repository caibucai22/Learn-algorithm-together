/**
 * @author Csy
 * @Classname Test结果填空
 * @date 2022-03-24 13:28
 * @Description TODO
 */
public class Test结果填空 {

    public static int count = 0;
    public static void dfs(double[] a,int index) {
        // 结束条件
        if(index == 9) {
            if(a[0]+a[1]/a[2]+(a[3]*100+a[4]*10+a[5])/(a[6]*100+a[7]*10+a[8]) == 10)
                count++;
            return;
        } else {
            for(int i=index; i<a.length; i++) {
                double t = a[index]; a[index]=a[i]; a[i] = t;
                dfs(a,index+1);
                t = a[index]; a[index]=a[i]; a[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        double[] a = new double[] {1.00,2.00,3.00,4.00,5.00,6.00,7.00,8.00,9.00};
        dfs(a,0);
        System.out.println(count);
    }

}


