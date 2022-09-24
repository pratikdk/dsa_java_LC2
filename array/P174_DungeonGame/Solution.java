package array.P174_DungeonGame;

import java.util.Arrays;

class Solution {
    //     public int calculateMinimumHP(int[][] dungeon) {
    //         int m = dungeon.length, n = dungeon[0].length;
    //         int[][] dp = new int[m][n];
    //         for (int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
    //         return dfsMove(dungeon, dp, 0, 0, m, n);
    //     }
        
    //     public int dfsMove(int[][] mat, int[][] dp, int i, int j, int m, int n) {
    //         // base cases
    //         if (i == m || j == n) return Integer.MAX_VALUE;
            
    //         if (i == m-1 && j == n-1) {
    //             return (mat[i][j] <= 0) ? 1 + (-mat[i][j]) : 1;
    //         }
            
    //         if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j]; // memoization
            
            
    //         int rightPathCost = dfsMove(mat, dp, i, j+1, m, n);
    //         int downPathCost = dfsMove(mat, dp, i+1, j, m, n);
            
    //         int currMinCost = Math.min(rightPathCost, downPathCost) - mat[i][j];
            
    //         dp[i][j] = (currMinCost <= 0) ? 1 : currMinCost;
    //         return dp[i][j];
    //     }
        
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                
                dp[i][j] = (need <= 0) ? 1 : need;
            }
        }
        
        return dp[0][0];
    }
}

// Player atleast needs >0 health to survive
// so, to survive a cell(r or d movement to dungeon[i][j]) the player should atleast have 1 + (-dungeon[i][j]) if <= 0 or else 1 health
// start at 0,0, return at boundaries or final cell m,n
// use either recursive(dfs) or dp(top or bottom) approach