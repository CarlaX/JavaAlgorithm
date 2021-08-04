package com.fzw.week06.question02;

import java.util.Arrays;

/**
 * @author fzw
 * @description 55. 跳跃游戏
 * @date 2021-08-04
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
//        能够跳到的最大位置的下标
        int[] res = new int[n];
        res[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = Integer.MIN_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j <= n - 1; j++) {
                temp = Math.max(temp, res[j]);
            }
            res[i] = temp;
        }
        System.out.println(Arrays.toString(res));
        return res[0] >= n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
