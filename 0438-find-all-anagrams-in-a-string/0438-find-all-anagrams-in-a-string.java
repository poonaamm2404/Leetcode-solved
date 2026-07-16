class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(s.length()<p.length()){
            return ans;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        for(int i=0;i<p.length();i++){
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pFreq, windowFreq)) {
            ans.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
            windowFreq[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}
    