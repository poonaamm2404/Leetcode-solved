class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pairXor = new boolean[2048];
        boolean[] tripletXor = new boolean[2048];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        for (int x = 0; x < 2048; x++) {
            if (pairXor[x]) {
                for (int num : nums) {
                    tripletXor[x ^ num] = true;
                }
            }
        }
        int count = 0;
        for (boolean b : tripletXor) {
            if (b) count++;
        }
        return count;
    }
}