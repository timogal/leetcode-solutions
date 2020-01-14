package com.zhyui.leetcode.ch40;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LiSiJie
 * @date 2020/1/14
 */
public class CombinationIISolutionTest {

    @Test
    public void combinationSum2() {
        CombinationIISolution combinationIISolution = new CombinationIISolution();
        int[] candidates1 = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        int[] candidates2 = new int[]{2, 5, 2, 1, 2};
        int target2 = 5;
        List<List<Integer>> res1 = combinationIISolution.combinationSum2(candidates1, target1);
        List<List<Integer>> res2 = combinationIISolution.combinationSum2(candidates2, target2);
        System.out.println(res1);
        System.out.println(res2);
    }
}