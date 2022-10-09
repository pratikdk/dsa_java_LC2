package snippets;

import java.util.*;

class S2 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        int[] arr = {2, 5, 8, 10, 20, 21};
        System.out.println(binarySearchLeft(arr, 20));
        System.out.println(binarySearchLeft(arr, 15));
        System.out.println(binarySearchLeft(arr, 21));
        System.out.println(binarySearchLeft(arr, 2));
        System.out.println(binarySearchLeft(arr, 3));
        System.out.println(binarySearchLeft(arr, 6));
        
        Set<Integer> st = new HashSet<>();
        st.add(20);
        st.add(30);
        
        Integer[] arr2 = st.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr2));
        
        Integer[] arr3 = {1, 2, 3};
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        dfs(arr3, 0, 0, 0, map1);
        System.out.println(map1);
    }
    
    public static int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    public static void dfs(Integer[] nums, int i, int currSum, int elemCount, Map<Integer, Set<Integer>> kSums) {
        if (i == nums.length) {
            kSums.putIfAbsent(elemCount, new HashSet<>());
            kSums.get(elemCount).add(currSum);
            return;
        }
        dfs(nums, i+1, currSum, elemCount, kSums);
        dfs(nums, i+1, currSum + nums[i], elemCount+1, kSums);
    }
}