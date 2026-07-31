import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int pushes = 1;
        int count = 0;
        int ans = 0;

        // Traverse from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            ans += freq[i] * pushes;
            count++;

            if (count == 8) {
                pushes++;
                count = 0;
            }
        }

        return ans;
    }
}