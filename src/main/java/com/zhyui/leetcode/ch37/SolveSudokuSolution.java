package com.zhyui.leetcode.ch37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * created at 2019/9/10
 *
 * @author LiSiJie
 */
public class SolveSudokuSolution {

    private static List<Character> numberCharacters = Arrays.asList(
            '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void solveSudoku(char[][] board) {
        Coordinate coordinate = pickNextBlank(board, null);
        if (coordinate == null) {
            return;
        }
        fillBlank(board, coordinate);
    }

    private void fillBlank(char[][] board, Coordinate coordinate) {
        int rownum = coordinate.rowIdx;
        int colnum = coordinate.colIdx;
        char[] possibleValues = coordinate.values;
        char value;
        boolean solved = false;
        while (coordinate.tryIdx < possibleValues.length) {
            value = possibleValues[coordinate.tryIdx];
            board[rownum][colnum] = value;
            // 找到下一个空白的点和可能值
            Coordinate next = pickNextBlank(board, coordinate);
            // 最后一个空白已经填充完成
            if (next == null) {
                solved = true;
                break;
            }
            // 没有可选值
            if (next.values.length == 0) {
                // 继续下一个可能值
                coordinate.tryIdx++;
                continue;
            }

            solved = true;

            // 填充下一个点
            fillBlank(board, next);
        }
        // 上一个点填充的值使当前无选择的值，回溯
        if (!solved) {
            if (coordinate.prev == null) {
                throw new IllegalArgumentException("no solution");
            }
            // 重置当前"坐标的值"
            board[rownum][colnum] = '.';
            // 回溯到前一个点的下一个可能值
            coordinate.prev.tryIdx++;
            fillBlank(board, coordinate.prev);
        }
    }

    private Coordinate pickNextBlank(char[][] board, Coordinate current) {
        int row;
        int col;
        if (current == null) {
            row = 0;
            col = 0;
        } else {
            row = current.colIdx >= 8 ? (current.rowIdx + 1) : current.rowIdx;
            col = current.colIdx >= 8 ? 0 : (current.colIdx + 1);
        }
        if (row > 8) {
            return null;
        }
        char c;

        // 从左到右，从上到下,寻找空白点
        while ((c = board[row][col]) != '.') {
            if (col == 8) {
                row++;
                if (row > 8) {
                    break;
                }
                col = 0;
            } else {
                col++;
            }
        }
        if (row > 8) {
            return null;
        }
        char[] possibleValues = pickPossibleValues(board, row, col);
        Coordinate result = new Coordinate(row, col, possibleValues);
        result.prev = current;
        return result;
    }

    private char[] pickPossibleValues(char[][] board, int rowIdx, int colIdx) {
        Set<Character> invalidValues = new HashSet<>(9);
        char[] row;
        char value;
        for (int i = 0; i < board.length; i++) {
            row = board[i];
            for (int j = 0; j < row.length; j++) {
                boolean inSameArea =
                        i == rowIdx
                                || j == colIdx
                                || (i / 3 == rowIdx / 3 && j / 3 == colIdx / 3);
                if (!inSameArea) {
                    continue;
                }
                value = row[j];
                if (value == '.') {
                    continue;
                }
                invalidValues.add(value);
            }
        }
        List<Character> result;
        if (invalidValues.isEmpty()) {
            result = numberCharacters;
        } else {
            result = numberCharacters.stream()
                    .filter(c -> !invalidValues.contains(c))
                    .collect(Collectors.toList());
        }
        int size = result.size();
        char[] values = new char[result.size()];
        for (int i = 0; i < size; i++) {
            values[i] = result.get(i);
        }
        return values;
    }

    private static class Coordinate {
        int rowIdx;
        int colIdx;
        char[] values;
        /**
         * 当前尝试的可能值的index
         */
        int tryIdx = 0;
        Coordinate prev;

        Coordinate(int rowIdx, int colIdx, char[] values) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
            this.values = values;
        }
    }
}
