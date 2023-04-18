package com.lql;

import org.junit.jupiter.api.Test;

class Solution {
    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (((sum + target) & 1) == 1) {
            return 0;
        }
        sum = (sum + target) / 2;
        int[][] dp = new int[nums.length + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}