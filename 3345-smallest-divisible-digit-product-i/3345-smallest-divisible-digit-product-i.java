class Solution {
    public int smallestNumber(int n, int t) {
        return checkProd(n,t);
    }
     int checkProd(int num, int t) {
        int dup = num;
        int digit = 1, prod = 1;

        while (dup > 0) {
            digit = dup % 10;
            dup = dup / 10;
            prod = digit * prod;
        }

        if (prod % t == 0) {
            return num;
        } else {
            return checkProd(num + 1, t);
        }
    }
}