package com.fzw.week01.question04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzw
 * @description 560. 和为K的子数组
 * @date 2021-06-29
 **/
public class Solution {

    @Test
    public void test() {
        System.out.println(this.subarraySum(new int[]{1, 1, 1,}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preCount = 0;
        int result = 0;
        map.put(0, 1);
        for (int num : nums) {
            preCount = preCount + num;
            int temp = preCount - k;
            if (map.containsKey(temp)) {
                result = result + map.get(temp);
            }
            if (map.containsKey(preCount)) {
                map.put(preCount, map.get(preCount) + 1);
            } else {
                map.put(preCount, 1);
            }
        }
        return result;
    }

}
