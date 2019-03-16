package SortingAlgorithm;

/*
*
*
* 若快排选择的划分值不平均的话（值不是在整个数据的中间区域）或基本有序
* 导致出现多次递归（每次只排好一个数）
* 时间复杂度将退化为o（n^2)
*
*
* */
public class QuickSortExp {
    public static int i;

    public static int Partition(int[] arr, int L, int R) {
        int p = arr[R];
        int less = L - 1; //小于p区，区域小于等于右边界
        for (int i = L; i <= R; i++) {
            if (arr[i] <= p)
                swap(arr, ++less, i);
        }
        return less;
    }

    //荷兰国旗问题    以最后一个值为划分，小于这个数为左边部分，大于这个数右边部分，中间为等于区域
    public static int[] partition1(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more}; //返回的是等于区域的左边界和右边界
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void quickSort(int arr[],int l,int r){
        if (l<r){
            swap(arr,(int)(Math.random() * (r-l+1)),r); //取一个随机划分值
        int[] p =partition1(arr,l,r);
        quickSort(arr,l,p[0]-1);    //左边部分快排
        quickSort(arr,p[1]+1,r);    //右边部分快排
        }
    }



    public static void main(String[] args) {

        int arr[] = {1, 2, 9, 7, 5, 3, 4};
        int index = Partition(arr, 0, arr.length - 1);
        int arr1[] = {1, 4, 9, 7, 5, 3, 4};
        int result[] = partition1(arr1, 0, arr1.length - 1);

        for (int e :
                arr1) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("左边界：" + result[0]);

        System.out.println("右边界：" + result[1]);

    }
}
