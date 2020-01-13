package com.zhyui.leetcode.ch39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSiJie
 * @date 2020/1/13
 */
public class CombinationSolution {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 解答参考：<a href="https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/">java解决方法</a>
     *
     * @param candidates 搜寻数组
     * @param target     目标元素
     * @return 可以使数字和为 target 的组合。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1. 根据问题定义一个解空间，它包含问题的解
        Arrays.sort(candidates);
        List<List<Integer>> solutions = new ArrayList<>();
        backtracking(solutions, new Stack<>(), candidates, 0, target);
        return solutions;
    }

    /**
     * 回溯法求解
     *
     * @param solutions  解集合
     * @param chain      当前解的链
     * @param candidates 候选数组
     * @param start      搜索解开始的index
     * @param target     目标数字
     */
    private void backtracking(
            List<List<Integer>> solutions,
            Stack<Integer> chain,
            int[] candidates,
            int start,
            int target) {
        // 找到一个解
        if (target == 0) {
            solutions.add(new ArrayList<>(chain));
            return;
        }
        int tmp;
        // target >= candidates[i]: 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        // target < candidates[i]: 表示该条解不成立
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            tmp = candidates[i];
            chain.add(tmp);
            // start = i: 数字可以重用，这里递归传递下去的是 i 而不是 i + 1；从i开始：栈中后一个元素若比
            // 前一个元素小，则表示前面的解已经使用过该解（重复路径），需要剪枝
            // target - tmp: 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
            backtracking(solutions, chain, candidates, i, target - tmp);
            chain.pop();
        }
    }
}
