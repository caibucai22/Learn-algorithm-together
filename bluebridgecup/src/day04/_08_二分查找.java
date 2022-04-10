package day04;

/**
 * @author Csy
 * @Classname _08_二分查找
 * @date 2022-01-22 10:48
 * @Description TODO
 */
public class _08_二分查找 {

    public static void main(String[] args) {


    }

    static int binarySearch(int[] arr,int low,int high,int key){
        if(low > high){
            return -1;
        }
        int mid = low +(high-low)/2;

        if(key == arr[mid]){
            return mid;
        }

        if(key > arr[mid]){
            return binarySearch(arr,mid+1,high,key);
        }else{
            return binarySearch(arr,low,mid-1,key);
        }
    }
}
