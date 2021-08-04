package com.fzw.week06.question01;

import java.util.Arrays;

/**
 * @author fzw
 * @description 279. 完全平方数
 * @date 2021-08-04
 **/
public class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
