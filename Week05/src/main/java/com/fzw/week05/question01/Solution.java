package com.fzw.week05.question01;

/**
 * @author fzw
 * @description 1011. 在 D 天内送达包裹的能力
 * @date 2021-07-22
 **/
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            sum = sum + weight;
        }
        while (min < sum) {
            int mid = (min + sum) / 2;
            if (this.canTransport(weights, days, mid)) {
                sum = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean canTransport(int[] weights, int days, int capacity) {
        int t = 1;
        int c = 0;
        int i = 0;

        while (i < weights.length) {
            if (c + weights[i] > capacity) {
                t++;
                c = 0;
            } else {
                c = c + weights[i];
                i++;
            }
            if (t > days) {
                return false;
            }
        }
        return true;
    }
}
