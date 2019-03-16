package SortingAlgorithm;

/*
*
* 桶排序经典例题
* 对n个数的数组，求相邻两元素之间的最大差值
*   分析：
*   相邻元素的最大差值，存在一个空桶的两个非空桶之间，
*                   或者存在两个非空桶之间
* n个数准备n+1个桶
*
* */
public class bucketSortExp {
    //桶排序
    public static void bucketSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                //先比较bucket[j]--是否大于0，再让bucket[j]--;
                arr[i++] = j;
                //arr[1，1，1，1，0，0，0，0，.......]
            }
        }
    }

    public static int maxGroup(int[] nums) {

        int len = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //确定桶的最大最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (max == min) {
            return 0;
        }

        //桶的三个数据
        boolean[] hasNum = new boolean[max + 1];//记录当前位置是否存在数
        int maxs[] = new int[max + 1];  //记录当前桶的最大值
        int mins[] = new int[max + 1];//记录当前桶的最小值

        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);   //桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];   //没有进过数，最小就是当前元素
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid] = true; //进去了数，改为true
        }
        int res = 0;
        int lastMax = maxs[0]; //第一个桶的最大值
        for (int i = 0; i < len; i++) {
            res = Math.max(res,mins[i]-lastMax);    //当前桶的最小值减去上一个桶最大值
            lastMax = maxs[i];                  //当前桶最大值赋给lastMax，继续向下比较
        }
        return res;
    }

    //查看当前数应该放在哪个桶
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int arr[] = {1, 50, 33, 78, 29, 98, 45};
    }

}
