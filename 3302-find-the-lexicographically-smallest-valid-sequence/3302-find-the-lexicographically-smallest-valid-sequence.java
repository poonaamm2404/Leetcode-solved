class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[i] = maximum number of characters
        // from word2 that can be matched using word1[i...]
        int[] suf = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];

            int j = m - suf[i + 1] - 1;

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        int count = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < n && p < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(p)) {
                ans[count++] = i;
                p++;
            }

            // Use the one allowed mismatch
            else if (!usedMismatch) {

                int need = m - (p + 1);

                if (suf[i + 1] >= need) {
                    ans[count++] = i;
                    p++;
                    usedMismatch = true;
                }
            }
        }

        if (count != m) {
            return new int[0];
        }

        return ans;
    }
}