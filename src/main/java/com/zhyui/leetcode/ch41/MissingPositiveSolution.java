package com.zhyui.leetcode.ch41;

/**
 * @author LiSiJie
 * @date 2020/1/15
 */
public class MissingPositiveSolution {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     * <p>
     * 输入: [7,8,9,11,12]
     * 输出: 1
     * 说明:
     * <p>
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean hasOne = false;
        // 寻找1是否在数组内,若不在数组内，则最小正整数为1
        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return 1;
        }

        // 若数组长度为1，则最小正整数为2
        if (len == 1) {
            return 2;
        }

        // 1. 将0, 负数和大于数组长度的数字替换为1 (若最大的数字超过数组长度，则未出现的正整数一定小于n)
        for (int i = 0; i < len; i++) {
            if (nums[i] < 1 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        int n;
        // 根据数组下标index对应的数字, 下标为index对应的数字若为负数则表示数字index + 1存在
        // 下标index: | 0/1 | 1/2 | 2/3 | 3/4 |
        // 原始数组：  | 3 | 4 | -1 | 1 |
        // Step1：    | 3 | 1 | 1 | 1 |
        // Step2：    | 3 | 1 | -1 | 1 |
        //            | -3 | 1 | -1 | 1 |
        //            | -3 | 1 | -1 | 1 |
        //            | -3 | 1 | -1 | 1 |
        for (int i = 0; i < len; i++) {
            n = Math.abs(nums[i]);
            int m = Math.abs(nums[n - 1]);
            nums[n - 1] = -m;
        }

        for (n = 1; n < len; n++) {
            if (nums[n] > 0) {
                break;
            }
        }

        return n + 1;
    }
}
