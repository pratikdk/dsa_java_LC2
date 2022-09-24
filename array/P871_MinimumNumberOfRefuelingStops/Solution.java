package array.P871_MinimumNumberOfRefuelingStops;

import java.util.PriorityQueue;

class Solution {
    // // dp, n^2
    // public int minRefuelStops(int target, int startFuel, int[][] stations) {
    //     int[] dp = new int[stations.length + 1];
    //     dp[0] = startFuel;
    //     for (int i = 0; i < stations.length; i++) {
    //         for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t--) {
    //             dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
    //         }
    //     }
    //     for (int t = 0; t < dp.length; t++) {
    //         if (dp[t] >= target) {
    //             return t;
    //         }
    //     }
    //     return -1;
    // }
    
    // using pq, nlogn
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        int i = 0;
        int res; // required number of stops
        int currFuel = startFuel;
        
        for (res = 0; currFuel < target; res++) {
            while (i < stations.length && stations[i][0] <= currFuel) {
                pqMax.offer(-stations[i++][1]);
            }
            if (pqMax.isEmpty()) return -1;
            currFuel += -pqMax.poll();
        }
        
        return res;
    }
}

// dp[t] means the furthest distance that we can get with t(i.e t stations) times of refueling.
// So for every station s[i],
// if the current distance dp[t] >= s[i][0], we can refuel:
// dp[t + 1] = max(dp[t + 1], dp[t] + s[i][1])
// In the end, we'll return the first t with dp[t] >= target

// We add all reachable stop to priority queue.
// We pop out the largest gas from pq and refeul once.
// If we can't refuel, means that we can not go forward and return -1