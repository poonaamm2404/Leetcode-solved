class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int n = nums.size();

        unordered_map<int, int> count;

        for (int i = 0; i <= n - k; i++) {
            unordered_set<int> seen;

            for (int j = i; j < i + k; j++) {
                if (seen.insert(nums[j]).second) {
                    count[nums[j]]++;
                }
            }
        }

        int ans = -1;

        for (auto &[num, freq] : count) {
            if (freq == 1) {
                ans = max(ans, num);
            }
        }

        return ans;
    }
};