class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
        }
    }
