class Solution {
public:
    bool isAnagram(string s, string t) {
        int freq[26]={0};
        if(s.size()!=t.size()){
            return false;
        }
        for(int i=0;i<s.size();i++){
            char ch=s[i];
            char cha=t[i];
            freq[ch-'a']++;
            freq[cha-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
};