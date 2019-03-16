package Arrays;

/**
 * @Classname localMin
 * @Description TODO 数组中的局部最小值的位置
 * 局部最小值的位置，要求其均小于其两边的数，且首元素小于第二个元素，尾元素小于倒数第二个元素。
 * 返回出现的第一个局部最小值的位置
 * <p>
 * 思路：
 * 先看0位置 和n-1位置是否为局部最小值，若是直接返回，若不是，则其中间必有局部最小值，趋势是一个"凹"型
 * 直接取中间位置mid，若mid-1 < mid,则在0~mid-1上必存在局部最小值的位置，若mid>mid+1,则mid+1~n—1上必存在局部最小
 * 为二分查找法
 * @Date 2019-03-15 20:55
 * @Created by guo
 */
public class FindLocalMinIndexWithBinary {
    public static int BinarySearchMin(int[] arr,int left,int right) {
        if (arr[left] < arr[left+1]) {
            return left;
        }
        if (arr[right] < arr[right-1]) {
            return right;
        }
        while (left<right) {
            int mid = (left+right)/2;
            if (arr[mid] > arr[mid - 1]) {
                right =mid-1;
            }
            else if (arr[mid] > arr[mid + 1]) {
                left= mid+1;
            }
            else {
                return mid;
          }
        }
        return left;
    }
    private static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length-2;
        while (left<right){

            int mid = (left+right)/2;
            if (arr[mid] > arr[mid - 1]) {
                right =mid-1;
            }
            else if (arr[mid] > arr[mid + 1]) {
                left= mid+1;
            }
            else {
                return mid;
            }
        }
        return left;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }




}
