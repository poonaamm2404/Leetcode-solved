class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        int ans = (n - map.size()) * 2;

        int left = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);     // seats 2-5
        int middle = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);   // seats 4-7
        int right = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);    // seats 6-9

        for (int mask : map.values()) {
            boolean leftFree = (mask & left) == 0;
            boolean rightFree = (mask & right) == 0;
            boolean middleFree = (mask & middle) == 0;

            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || rightFree || middleFree) {
                ans += 1;
            }
        }

        return ans;
    }
}