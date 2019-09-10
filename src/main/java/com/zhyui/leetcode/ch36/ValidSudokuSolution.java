package com.zhyui.leetcode.ch36;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 *
 * @author LiSiJie
 */
public class ValidSudokuSolution {

    public boolean isValidSudoku(char[][] board) {
        // 记录每个数字所出现的所有坐标
        Map<Character, Coordinate[]> mappings = new HashMap<>(9);
        for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
            char[] row = board[rowIdx];
            for (int colIdx = 0; colIdx < row.length; colIdx++) {
                char c = row[colIdx];
                if (c == '.') {
                    continue;
                }
                if (mappings.containsKey(c)) {
                    Coordinate[] exist = mappings.get(c);
                    // 判断重复
                    if (hasRepeat(rowIdx, colIdx, exist)) {
                        return false;
                    }
                    // 不重复则将该点添加到数组
                    Coordinate[] newCoordinates = new Coordinate[exist.length + 1];
                    System.arraycopy(exist, 0, newCoordinates, 0, exist.length);
                    newCoordinates[exist.length] = new Coordinate(rowIdx, colIdx);
                    mappings.put(c, newCoordinates);
                } else {
                    mappings.put(c, new Coordinate[]{new Coordinate(rowIdx, colIdx)});
                }
            }
        }

        return true;
    }

    /**
     * 判断该点是否与其他点在同一区域
     */
    private boolean hasRepeat(int rownum, int colnum, Coordinate[] coordinates) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.inSameArea(rownum, colnum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数字出现的坐标
     */
    private static class Coordinate {
        // 行号
        final int row;
        // 列号
        final int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        /**
         * 判断两点是否在同一个区域内
         *
         * @param rownum 点的行号
         * @param colnum 点的列号
         */
        public boolean inSameArea(int rownum, int colnum) {
            if (rownum == row || colnum == column) {
                return true;
            }

            return (rownum / 3 == row / 3) && (colnum / 3 == column / 3);
        }
    }
}
