package sort;

/**
 * @author Csy
 * @Classname QuickSort
 * @date 2021/9/21 15:39
 * @Description TODO
 */
public class QuickSort {

    /**
     * ������ѣ��ϲ�����
     * ����ʱ�临�Ӷȣ�o nlgn
     */

    private static void quickSort(int[] array,int low,int high){

        if(low<high){
            int i = low,j = high,partition = array[low];
            while(i<j){
                while(i<j && array[j]>=partition){j--;}
                while(i<j&& array[i]<=partition){i++;}
                if(i<j){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            // ��ʱi�����λ����ͬ
            array[low] = array[j];
            array[j] = partition;

            // ��������д i j�ǵȼ۵�
            quickSort(array,low,j-1);
            quickSort(array,j+1,high);
        }
    }


    public static void main(String[] args) {
        int[] test = {49,38,65,97,76,13,27};
        quickSort(test,0,test.length-1);
        for (int i : test) {
            System.out.println(i);
        }
    }
}
