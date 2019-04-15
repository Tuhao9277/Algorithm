package Algorithm;

/**
 * @Classname Two_Sum
 * @Description TODO 二数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 我们需要让原数组中的元素从小到大依次有序，故需要对其进行调整，
 * 但还要记录原数组中各元素的索引位置，
 * 所以new 一个数组记录索引，
 * 对原数组arr进行排序
 * 设置左右两个指针，向中间走
 * 指向的元素大于target，说明右边的值太大，故向左走，
 * 小于的话，left向右走，
 * 若指向的元素相加之和等于target，将他们的索引值输出
 * @Date 2019-03-18 22:01
 * @Created by guo
 */
public class Two_Sum {
    public int[] twoSum(int[] arr, int target) {
        int[] indices = new int[arr.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        sort(arr, indices);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{indices[l], indices[r]};
            }
        }
        return new int[]{-1, -1};


    }

    public void sort(int[] nums, int[] indices) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, indices, i);
        }
        for (int i = nums.length; i >= 0; i--) {
            swap(nums, indices, 0, i);
            heapify(nums, indices, i);
        }
    }

    public void heapify(int[] nums, int[] indices, int size) {
        int i = 0;
        int left = 1;
        int right = 2;
        int largest;
        while (left < size) {
            largest = nums[left] > nums[i] ? left : i;
            largest = right < size && nums[right] > nums[largest] ? right : largest;
            if (largest == i) {
                break;
            }
            swap(nums, indices, largest, i);
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;

        }
    }

    public void heapInsert(int[] nums, int[] indices, int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (nums[i] <= nums[p]) {
                break;
            }
            swap(nums, indices, i, p);
            i = p;
        }
    }

    public void swap(int[] nums, int[] indices, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;

    }
}
