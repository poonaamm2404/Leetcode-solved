class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int hash[256];
        fill(hash, hash + 256, -1);
        int left=0, right=0, maxlen=0;
        while(right<s.size()){
            if(hash[s[right]]!=-1){
                if(hash[s[right]]>=left){
                    left=hash[s[right]]+1;
                }
            }
            int len=right-left+1;
            maxlen=max(len,maxlen);
            hash[s[right]]=right;
            right++;
        }
        return maxlen;
    }
};