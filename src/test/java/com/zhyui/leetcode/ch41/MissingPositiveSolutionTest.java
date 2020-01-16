package com.zhyui.leetcode.ch41;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LiSiJie
 * @date 2020/1/15
 */
public class MissingPositiveSolutionTest {

    @Test
    public void firstMissingPositive() {
        MissingPositiveSolution mps = new MissingPositiveSolution();
        int[] source0 = new int[]{2, 1};
        int[] source1 = new int[]{1, 2, 0};
        int[] source2 = new int[]{3, 4, -1, 1};
        int[] source3 = new int[]{7, 8, 9, 11, 12};
        assertEquals(3, mps.firstMissingPositive(source0));
        assertEquals(3, mps.firstMissingPositive(source1));
        assertEquals(2, mps.firstMissingPositive(source2));
        assertEquals(1, mps.firstMissingPositive(source3));
    }
}