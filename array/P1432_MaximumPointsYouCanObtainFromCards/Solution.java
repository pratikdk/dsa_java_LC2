package array.P1432_MaximumPointsYouCanObtainFromCards;
 
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int wSize = n - k;
        int j = 0, currSum = 0;
        int minWSum = Integer.MAX_VALUE; // minimum window sum
        
        for (int i = 0; i < n; i++) {
            currSum += cardPoints[i];
            if (i - j + 1 > wSize) {
                currSum -= cardPoints[j];
                j++;
            }
            if (i - j + 1 == wSize) {
                minWSum = Math.min(minWSum, currSum);
            }
        }
        
        int totalPoints = 0;
        for (int cardPoint: cardPoints) totalPoints += cardPoint; 
        
        return totalPoints - minWSum;
    }
}

// flip the problem statement to finding min window sum of size (cardPoints.length - k)
// Subtract this window sum from sum(cardPoints)