package DB.Stack;

import java.util.Stack;

/**
 * @Classname TrappingRainWater
 * @Description TODO 接雨水问题
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 * 思路：由图中可以看出左右高度的较小者，减去当前块高，就是所承水量
 *       *
 *    *  *
 * *  * **
 *
 * @Date 2019-03-15 22:15
 * @Created by guo
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int left = 0,
            right =0,
            water =0;
        for (int i = 0; i < height.length; i++) {
            if (left < height[i]) {
                left = height[i];   //left记录每个块左边的最大高度
            }
            stack.push(left);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (right < height[i]) {
                right = height[i];  //right为右边比当前值大的高度
            }
            int xLeft = stack.peek(); //当前块左边的最大高
            //取当前块左右最大高度的较小者
            int minx = xLeft < right ? xLeft : right;
            water += minx - height[i];
            stack.pop();
        }
        return water;
    }
    public static void main(String[] args){
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }
}
