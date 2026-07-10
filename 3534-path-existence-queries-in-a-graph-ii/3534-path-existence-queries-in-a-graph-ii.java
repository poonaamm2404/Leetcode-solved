import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        int[] comp = new int[n];
        int[] values = new int[n];

        int component = 0;

        values[0] = arr[0][0];
        pos[arr[0][1]] = 0;
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            values[i] = arr[i][0];
            pos[arr[i][1]] = i;

            if (values[i] - values[i - 1] > maxDiff) {
                component++;
            }

            comp[i] = component;
        }

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int left = i;
            int right = n - 1;
            int ans = i;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (values[mid] - values[i] <= maxDiff) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            next[i] = ans;
        }

        int LOG = 18;
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u == v) {
                answer[q] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                answer[q] = -1;
                continue;
            }

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            int jumps = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    jumps += (1 << k);
                }
            }

            answer[q] = jumps + 1;
        }

        return answer;
    }
}