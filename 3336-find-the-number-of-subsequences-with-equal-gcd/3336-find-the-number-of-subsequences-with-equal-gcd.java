class Solution {

    int MOD = 1000000007;
    Integer[][][] memo;

    public int subsequencePairCount(int[] nums) {

        memo = new Integer[nums.length + 1][201][201];

        return solve(0, 0, 0, nums);
    }

    int solve(int idx, int g1, int g2, int[] nums) {

        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != null)
            return memo[idx][g1][g2];

        long ans = 0;

        // Skip
        ans += solve(idx + 1, g1, g2, nums);

        // Put in first subsequence
        int ng1 = (g1 == 0) ? nums[idx] : gcd(g1, nums[idx]);
        ans += solve(idx + 1, ng1, g2, nums);

        // Put in second subsequence
        int ng2 = (g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
        ans += solve(idx + 1, g1, ng2, nums);

        return memo[idx][g1][g2] = (int)(ans % MOD);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}