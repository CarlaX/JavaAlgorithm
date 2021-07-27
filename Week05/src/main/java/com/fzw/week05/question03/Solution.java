package com.fzw.week05.question03;

/**
 * @author fzw
 * @description 875. 爱吃香蕉的珂珂
 * @date 2021-07-22
 **/
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mak = Integer.MIN_VALUE;
        int mik = 1;

        for (int pile : piles) {
            mak = Math.max(mak, pile);
        }

        while (mik < mak) {
            int mid = (mak + mik) / 2;
            System.out.println("mak: " + mak + " ; " + "mik: " + mik + " ; " + "mid: " + mid);
            if (this.canEat(piles, h, mid)) {
                mak = mid;
            } else {
                mik = mid + 1;
            }
        }

        return mak;
    }

    public boolean canEat(int[] piles, int h, int k) {
        int t = 0;

        for (int pile : piles) {
            t = t + (pile - 1) / k + 1;
            if (t > h) {
                return false;
            }
        }
        return true;
    }
}
