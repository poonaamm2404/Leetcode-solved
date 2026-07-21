class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0;
        int pre = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;
        int n = s.length();

        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;
            } else {
                maxGain = Math.max(maxGain, pre + len);
                pre = len;
            }

            i = j;
        }

        return ans + maxGain;
    }
}