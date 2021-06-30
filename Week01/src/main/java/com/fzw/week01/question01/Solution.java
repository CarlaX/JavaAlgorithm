package com.fzw.week01.question01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author fzw
 * @description 66. 加一
 * @date 2021-06-29
 **/
public class Solution {

    @Test
    public void test() {
        int[] result = null;
        result = this.plusOne(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
        result = this.plusOne(new int[]{1, 2, 3, 9});
        System.out.println(Arrays.toString(result));
        result = this.plusOne(new int[]{1, 2, 9, 9});
        System.out.println(Arrays.toString(result));
        result = this.plusOne(new int[]{1, 9, 9, 9});
        System.out.println(Arrays.toString(result));
        result = this.plusOne(new int[]{9, 9, 9, 9});
        System.out.println(Arrays.toString(result));
        result = this.plusOne(new int[]{0});
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp < 10) {
                digits[i] = temp;
                break;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    System.arraycopy(digits, 0, newDigits, 1, digits.length);
                    digits = newDigits;
                }
            }
        }
        return digits;
    }
}
