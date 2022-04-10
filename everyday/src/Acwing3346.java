import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Csy
 * @Classname Acwing3346
 * @date 2022-03-13 22:41
 * @Description TODO
 */
public class Acwing3346 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] nums =  new int[7];
        for(int i=0;i<7;i++){
            nums[i] = sc.nextInt();
        }

        // A、B、C、A+B、B+C、C+A  和 A+B+C
        Arrays.sort(nums);

        System.out.println(nums[0]+" "+nums[1]+" "+(nums[6]-nums[0]-nums[1]));


    }
}
