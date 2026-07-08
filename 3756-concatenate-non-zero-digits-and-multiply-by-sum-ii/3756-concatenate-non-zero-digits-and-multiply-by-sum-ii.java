class Solution {
    int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefSum = new int[n + 1];
        int[] cnt = new int[n + 1];
        long[] prefNum = new long[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            prefSum[i + 1] = prefSum[i] + d;
            cnt[i + 1] = cnt[i];
            prefNum[i + 1] = prefNum[i];
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            if (d != 0) {
                cnt[i + 1]++;
                prefNum[i + 1] = (prefNum[i] * 10 + d) % MOD;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = prefSum[r + 1] - prefSum[l];
            int k = cnt[r + 1] - cnt[l];
            long x = (prefNum[r + 1]
                    - (prefNum[l] * pow10[k]) % MOD
                    + MOD) % MOD;
            answer[i] = (int) ((x * sum) % MOD);
        }

        return answer;
    }
}