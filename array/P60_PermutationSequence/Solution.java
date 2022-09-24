package array.P60_PermutationSequence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) factorials[i] = factorials[i-1] * i;
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);
        
        StringBuilder sb = new StringBuilder();
        k--; 
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorials[n-i]; // find leading index;
            sb.append(numbers.get(index)); // append leading index to string
            numbers.remove(index); // remove from available numbers
            k = k - (index * (factorials[n-i]));
        }
        
        return sb.toString();
    }
}

// iteratively figure out the leading(index) digits from left to right, w.r.t k
// if, n = 3
// n! = 6
// 1 leads permutations of (2, 3);
// 2 leads permutations of (1, 3);
// 3 leads permutations of (1, 2);

// find k value respective of n!
// find index to use from available numbers as leading digit


//https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)