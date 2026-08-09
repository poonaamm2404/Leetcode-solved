class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = sum of piles from i to end
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles.length);
    }

    private int solve(int i, int M, int n) {

        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int maxStones = 0;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X),
                n
            );

            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}