class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        set<vector<int>> unique;

        sort(nums.begin(), nums.end());

        for(int i = 0; i < nums.size(); i++) {

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            unordered_set<int> seen;

            for(int j = i + 1; j < nums.size(); j++) {

                int third = -(nums[i] + nums[j]);

                if(seen.find(third) != seen.end()) {
                    vector<int> temp = {nums[i], third, nums[j]};
                    sort(temp.begin(), temp.end());

                    unique.insert(temp);
                }

                seen.insert(nums[j]);
            }
        }

        for(auto x : unique) {
            ans.push_back(x);
        }

        return ans;
    }
};