package sort;

/**
 * @author Csy
 * @Classname BubbleSort
 * @date 2021/9/21 17:30
 * @Description TODO
 */
public class BubbleSort {

    public static void bubbleSort(int[] array){
        int n = array.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {49,38,65,97,76,13,27};
        bubbleSort(test);
        for (int i : test) {
            System.out.print(i+" ");
        }
    }
}
