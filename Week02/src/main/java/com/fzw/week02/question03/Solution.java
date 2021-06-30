package com.fzw.week02.question03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fzw
 * @description 697. 数组的度
 * @date 2021-06-30
 **/
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
                rightMap.put(nums[i], i);
            } else {
                map.put(nums[i], 1);
                leftMap.put(nums[i], i);
                rightMap.put(nums[i], i);
            }
        }

        int maxCount = Collections.max(map.values());
        int minLen = nums.length;
        for (int i : map.keySet()) {
            if (map.get(i) == maxCount) {
                minLen = Math.min(minLen, rightMap.get(i) - leftMap.get(i) + 1);
            }
        }
        return minLen;
    }
}
