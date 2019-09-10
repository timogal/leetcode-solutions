package com.zhyui.leetcode.ch35;

/**
 * created at 2019/9/10
 *
 * @author LiSiJie
 */
public class ImprovedSolution {

    /**
     * 二分法搜寻目标数字
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 低位index
        int low = 0;
        // 高位index
        int high = nums.length - 1;

        int midVal;
        int idx;
        while (low <= high) {
            idx = (low + high) / 2;
            midVal = nums[idx];
            if (midVal > target) {
                // 中间位数字超出目标值，高位数字大了，高位向低位移动1位
                high--;
            } else if (midVal < target) {
                // 中间数字小于目标值，低位数字小了，低位向高位进一位
                low++;
            } else {
                // 相等，返回
                return idx;
            }
        }
        // 低位向前,取低位
        return low;
    }
}
