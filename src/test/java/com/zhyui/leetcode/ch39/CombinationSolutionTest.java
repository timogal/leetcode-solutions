package com.zhyui.leetcode.ch39;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LiSiJie
 * @date 2020/1/13
 */
public class CombinationSolutionTest {

    @Test
    public void combinationSum() {
        int[] candidates1 = new int[]{2, 3, 6, 7};
        int target1 = 7;
        int[] candidates2 = new int[]{2, 3, 5};
        int target2 = 8;
        CombinationSolution combinationSolution = new CombinationSolution();
        System.out.println(combinationSolution.combinationSum(candidates1, target1));
        System.out.println(combinationSolution.combinationSum(candidates2, target2));
    }
}