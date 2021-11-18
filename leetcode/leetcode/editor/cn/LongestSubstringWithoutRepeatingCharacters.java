package editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        //右指针
        int point = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            //左指针i
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (point < len && !set.contains(s.charAt(point))) {
                set.add(s.charAt(point));
                point++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}