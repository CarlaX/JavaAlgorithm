package com.fzw.week06.question03;

import java.util.Arrays;

/**
 * @author fzw
 * @description 45. 跳跃游戏 II
 * @date 2021-08-04
 **/
public class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int temp = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j <= n - 1; j++) {
                temp = Math.min(temp, res[j]);
            }
            res[i] = temp + 1 < 0 ? Integer.MAX_VALUE : temp + 1;
        }
        System.out.println(Arrays.toString(res));
        return res[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
