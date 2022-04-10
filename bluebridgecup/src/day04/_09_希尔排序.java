package day04;

/**
 * @author Csy
 * @Classname _09_希尔排序
 * @date 2022-01-22 11:00
 * @Description TODO
 */
public class _09_希尔排序 {

    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        // 增量
        for (int interval = arr.length / 2; interval > 0; interval /= 2) {


            // 插入排序
            for (int i = interval;i<arr.length;i++) {

                int target = arr[i];
                int j = i - interval;
                while (j> -1 && arr[j] > target) {
                    arr[j+interval] = arr[j];
                    j -= interval;
                }
                arr[j+interval] = target;

            }

        }

        for(int num:arr){
            System.out.print(num+" ");
        }

    }
}
