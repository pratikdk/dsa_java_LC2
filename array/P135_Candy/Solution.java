package array.P135_Candy;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                nums[i] = nums[i-1] + 1;
            }
        }
        
        for (int i = n-1; i > 0; i--) {
            if (ratings[i] < ratings[i-1]) {
                nums[i-1] = Math.max(nums[i-1], nums[i]+1);
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i];
        }
        
        return res;
    }
}

// perform left to right sweep; comparing a[i-1] < a[i];
// perform right to left sweep; comparing a[i-1] > a[i]; take max(a[i-1], a[i]+1)

// https://leetcode.com/problems/candy/discuss/42769/A-simple-solution