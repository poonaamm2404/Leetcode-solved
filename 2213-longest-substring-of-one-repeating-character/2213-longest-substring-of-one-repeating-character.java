class Solution {

    class Node {
        int l, r;
        int leftMax, rightMax, max;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.leftMax = 1;
            this.rightMax = 1;
            this.max = 1;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String s, String queryCharacters,
                                   int[] queryIndices) {

        this.s = s.toCharArray();
        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(1, 0, n - 1,
                   queryIndices[i],
                   queryCharacters.charAt(i));

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        tree[node] = new Node(l, r);

        if (l == r)
            return;

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node);
    }

    void update(int node, int l, int r, int index, char ch) {

        if (l == r) {
            s[index] = ch;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, ch);
        else
            update(node * 2 + 1, mid + 1, r, index, ch);

        merge(node);
    }

    void merge(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        cur.leftMax = left.leftMax;
        cur.rightMax = right.rightMax;

        cur.max = Math.max(left.max, right.max);

        // Boundary characters are same
        if (s[left.r] == s[right.l]) {

            // Entire left part is same character
            if (left.leftMax == left.r - left.l + 1)
                cur.leftMax += right.leftMax;

            // Entire right part is same character
            if (right.rightMax == right.r - right.l + 1)
                cur.rightMax += left.rightMax;

            // Join suffix of left + prefix of right
            cur.max = Math.max(
                cur.max,
                left.rightMax + right.leftMax
            );
        }
    }
}