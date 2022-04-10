package day04;

/**
 * @author Csy
 * @Classname _06_插入排序
 * @date 2022-01-22 10:19
 * @Description TODO
 */
public class _06_插入排序 {

    public static void main(String[] args) {


    }


    static void insertSort(int[] arr,int k){
        if(k==0){
            return;
        }

        insertSort(arr,k-1);
        int x = arr[k];
        int index = k-1;
        while(x < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = x;
    }
}
