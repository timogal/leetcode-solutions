package com.zhyui.leetcode.ch40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author LiSiJie
 * @date 2020/1/14
 */
public class CombinationIISolution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> solutions = new ArrayList<>();
        backtracking(
                solutions,
                new Stack<>(),
                candidates,
                0,
                target
        );
        return solutions;
    }

    private void backtracking(
            List<List<Integer>> solutions,
            Stack<Integer> chain,
            int[] candidates,
            int start,
            int target
    ) {
        if (target == 0) {
            solutions.add(new ArrayList<>(chain));
            return;
        }
        // 排除重复的序列
        Set<Integer> usedNums = new HashSet<>(candidates.length);
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (usedNums.contains(candidates[i])) {
                continue;
            }
            usedNums.add(candidates[i]);
            chain.add(candidates[i]);
            backtracking(solutions, chain, candidates, i + 1, target - candidates[i]);
            chain.pop();
        }
    }
}
