class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];

        for (int x : stones) {
            cnt[x % 3]++;
        }

        return check(cnt[0], cnt[1], cnt[2]) ||
               check(cnt[0], cnt[2], cnt[1]);
    }

    private boolean check(int zero, int one, int two) {
        if (one == 0) {
            return false;
        }

        // Alice takes one remainder-1 stone
        one--;

        // Then 1 and 2 alternate
        int pairs = Math.min(one, two);

        int moves = 1 + pairs * 2;

        one -= pairs;
        two -= pairs;

        // If extra 1 exists, it can be taken once more
        if (one > 0) {
            moves++;
            one--;
        }

        // Remainder-0 stones can be inserted into the game.
        moves += zero;

        // Alice wins if:
        // 1. Number of moves is odd
        // 2. Some stone is still remaining
        return moves % 2 == 1 && (one + two > 0);
    }
}