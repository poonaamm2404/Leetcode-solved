class Solution {
    public int maxVowels(String s, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                sum++;
            }
        }

        int max = sum;

        for (int i = k; i < s.length(); i++) {

            char add = s.charAt(i);
            if (add == 'a' || add == 'e' || add == 'i' || add == 'o' || add == 'u') {
                sum++;
            }

            char remove = s.charAt(i - k);
            if (remove == 'a' || remove == 'e' || remove == 'i' || remove == 'o' || remove == 'u') {
                sum--;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}