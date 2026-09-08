class Solution {
    public int countCommas(int n) {
        int count = 0;
        long power = 1000;
        while (power <= n) {
            count += n - power + 1;
            power *= 1000;
        }
        return count;
    }
}