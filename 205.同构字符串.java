import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) {
            return false;
        }

        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
         
        for (int i = 0; i < lenS; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (s2t.containsKey(ss) && s2t.get(ss) != tt || 
                t2s.containsKey(tt) && t2s.get(tt) != ss) {
                    return false;
            }
            s2t.put(ss, tt);
            t2s.put(tt, ss);
        }
        return true;
    }
}
// @lc code=end

