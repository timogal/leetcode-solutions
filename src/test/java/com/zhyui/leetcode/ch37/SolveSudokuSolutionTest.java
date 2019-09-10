package com.zhyui.leetcode.ch37;

import com.zhyui.leetcode.ch36.ValidSudokuSolution;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * created at 2019/9/10
 *
 * @author LiSiJie
 */
public class SolveSudokuSolutionTest {

    @Test
    public void solveSudoku() {
        char[][] input = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new SolveSudokuSolution().solveSudoku(input);

        System.out.println(Arrays.deepToString(input));

        boolean valid = new ValidSudokuSolution().isValidSudoku(input);

        assertTrue(valid);
    }
}