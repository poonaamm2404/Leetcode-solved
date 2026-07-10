class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        double avg=0;
        double max = Double.NEGATIVE_INFINITY;
        int size=nums.length-k+1;
        for(int i=0;i<size;i++){
            sum=0;
            for(int j=i;j<k+i;j++){
                sum+=nums[j];
            }
            avg=(double)sum/k;
            max = Math.max(max, avg);
        }
        return max;
    }
}
