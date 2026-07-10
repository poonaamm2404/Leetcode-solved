class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc=true;
        boolean dec=true;
        int i=0;
        while(i<nums.length-1){
             if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
            i++;
        
        }
        return inc || dec;
    }
}