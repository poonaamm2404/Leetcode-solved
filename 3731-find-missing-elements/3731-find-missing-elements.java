class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}