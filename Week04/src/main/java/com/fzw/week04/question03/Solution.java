package com.fzw.week04.question03;

/**
 * @author fzw
 * @description 154. 寻找旋转排序数组中的最小值 II
 * @date 2021-07-14
 **/
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return this.binarySearch(0, nums.length - 1, nums);
    }

    public int binarySearch(int start, int end, int[] nums) {
        int low = nums[start];
        int high = nums[end];
        int cur = start + (end - start) / 2;
        int mid = nums[cur];

        if (start >= end) {
            return mid;
        }
        if (mid < high) {
            return this.binarySearch(start, cur, nums);
        } else if (mid > high) {
            return this.binarySearch(cur + 1, end, nums);
        } else {
            return this.binarySearch(start, end - 1, nums);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{2, 2, 2, 0, 1, 2}));
    }

}
