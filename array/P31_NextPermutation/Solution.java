package array.P31_NextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k, l;
        for (k = n-2; k >= 0; k--) {
            if (nums[k] < nums[k+1]) break;
        }
        
        if (k < 0) reverse(nums, 0, n-1);
        else {
            for (l = n-1; l > k; l--) {
                if (nums[l] > nums[k]) break;
            }

            swap(nums, k, l);
            reverse(nums, k+1, n-1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}

// first find k then l
// such that k < k+1; larget k
// k < l and nums[k] < nums[l]; largest l


//https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia