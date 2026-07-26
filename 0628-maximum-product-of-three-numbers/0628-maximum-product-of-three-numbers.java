class Solution {
    public int maximumProduct(int[] nums) {
        int num1=Integer.MIN_VALUE;
        int num2=Integer.MIN_VALUE;
        int num3=Integer.MIN_VALUE;
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>num1){
                num3=num2;
                num2=num1;
                num1=nums[i];
            }
            else if (nums[i] > num2) {
                num3 = num2;
                num2 = nums[i];
            }
           else if (nums[i] > num3) {
                num3 = nums[i];
            }
            if (nums[i] < small1) {
                small2 = small1;
                small1 = nums[i];
            }
            else if (nums[i] < small2) {
                small2=nums[i];
            }
        }
        int result=Math.max(num1*num2*num3,num1*small1*small2);
        return result;
    }
}