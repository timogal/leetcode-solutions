package com.zhyui.leetcode.ch35;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created at 2019/9/9
 *
 * @author LiSiJie
 */
public class SearchInsertSolutionTest {

    @Test
    public void searchInsert() {
        int[] nums = new int[]{1, 3, 5, 7};
        int target = 6;

        int result = new SearchInsertSolution().searchInsert(nums, target);

        assertEquals(3, result);
    }
}