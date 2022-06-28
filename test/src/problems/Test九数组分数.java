/**
 * @author Csy
 * @Classname Test九数组分数
 * @date 2022-03-24 13:12
 * @Description TODO
 */
public class Test九数组分数 {

    public static void dfs(int[] a, int index) {
        // 结束条件
        if(index == 9) {
            int m = a[0]*1000+a[1]*100+a[2]*10+a[3];
            int n = a[4]*10000+a[5]*1000+a[6]*100+a[7]*10+a[8];
            if(m*3 == n)
                System.out.println(m+" "+n);
            return;
        }

        for(int i=index; i<a.length; i++){
            int t=a[index]; a[index]=a[i]; a[i]=t; // 交换a[index]和a[i]
            dfs(a,index+1);
            t=a[index]; a[index]=a[i]; a[i]=t; // 再次交换a[index]和a[i]
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        dfs(a,0);
    }
}






