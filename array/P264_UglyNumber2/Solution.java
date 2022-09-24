package array.P264_UglyNumber2;

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int minF = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = minF;
            
            if (minF == factor2) {
                factor2 = 2 * ugly[++index2];    
            } 
            if (minF == factor3) {
                factor3 = 3 * ugly[++index3];
            } 
            if (minF == factor5) {
                factor5 = 5 * ugly[++index5];
            }
        }
        
        return ugly[n-1];
    }
}

// consider sequence of positive integers [1, 2, 3, 4, 5, ... ] and multiply(factor) each by 2, 3, 5 (prime numbers)
// the values thus obtained are prime factors of positive integers; ugly numbers
// return nth(n-1) ugly value
// maintain 3 seperate index and 3 factor containers; for 2, 3, 5. compare and shift index of min factor
