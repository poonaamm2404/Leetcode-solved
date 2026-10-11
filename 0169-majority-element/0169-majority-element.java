class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ans=0;
        int count=0;
        for(int i=0;i<n;i++){
            int ele=nums[i];
            if (count == 0) {
                ans = ele;
            }
            if(ans==ele){
                count++;
            }
            else{
                count--;
            }
        }
        return ans;
    }
}