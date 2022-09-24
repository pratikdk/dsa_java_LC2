package array.P34_FindFirstAndLastPositionOfElementInSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = {-1, -1};
        if (n == 0) return res;
        int l = 0, r = n-1;
        
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < target) l = mid+1;
            else r = mid;
        }
        // l and r both are equal now
        if (nums[l] != target) return res;
        else res[0] = l;
        
        r = n-1;
        while (l < r) {
            int mid = (l+r)/2 + 1; // right biased; to avoid l getting stuck; eg 8, 8
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        
        res[1] = r;
        return res;
    }
}


// binary search twice, first find left then right index

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14699/Clean-iterative-solution-with-two-binary-searches-(with-explanation)