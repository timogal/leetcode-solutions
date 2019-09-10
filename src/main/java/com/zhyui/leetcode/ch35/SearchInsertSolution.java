package com.zhyui.leetcode.ch35;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 *
 * @author LiSiJie
 */
public class SearchInsertSolution {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = nums.length / 2;
        int hit = nums[idx];
        if (hit == target) {
            return idx;
        }
        int last = hit;
        boolean searchBottom = hit > target;
        while (true) {
            if (searchBottom) {
                // 向下查找
                idx--;
            } else {
                // 向上查找
                idx++;
            }
            if (idx < 0 || idx >= nums.length) {
                break;
            }
            hit = nums[idx];
            // 相等
            if (hit == target) {
                return idx;
            }
            // 向下查询到
            if (last > target && target > hit) {
                return idx + 1;
            }
            // 向上查询到
            if (last < target && target < hit) {
                return idx;
            }
        }
        // 边界情况
        return idx < 0 ? 0 : nums.length;
    }
}
