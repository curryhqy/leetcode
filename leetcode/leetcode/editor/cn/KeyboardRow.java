package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] res = solution.findWords(words);
        for (String s : res) {
            System.out.println(s);
        }
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class Solution {
    static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];

    //每个字母属于哪一级 0 1 2
    static {
        for (int i = 0; i < ss.length; i++) {
            for (char c : ss[i].toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out: for (String w : words) {
            int t = -1;
            for (char c : w.toCharArray()) {
                //全部按小写处理
                c = Character.toLowerCase(c);
                if (t == -1) {
                    t = hash[c - 'a'];
                } else if (t != hash[c - 'a']) {
                    continue out;
                }
            }
            list.add(w);
        }
        return list.toArray(new String[list.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}