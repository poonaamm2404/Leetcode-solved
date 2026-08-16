class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minp=prices[0];
        int profit=0;
        for(int i=0;i<prices.size();i++){
            int cost=prices[i]-minp;
            profit=max(cost,profit);
            minp=min(minp,prices[i]);
        }
        return profit;
    }
};