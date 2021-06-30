package com.fzw.week02.question04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzw
 * @description 1074. 元素和为目标值的子矩阵数量
 * @date 2021-06-30
 **/
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preMatrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] + matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 1; k <= m; k++) {
                    cur = preMatrix[j][k] - preMatrix[i - 1][k];
                    if (cur == target) {
                        result++;
                    }
                    if (map.containsKey(cur - target)) {
                        result = result + map.get(cur - target);
                    }
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) + 1);
                    } else {
                        map.put(cur, 1);
                    }
                }
            }
        }
        return result;
    }
}
