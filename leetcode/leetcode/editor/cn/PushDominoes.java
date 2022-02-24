package editor.cn;

public class PushDominoes{
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int len = s.length;
        int i = 0;
        char left = 'L';
        while (i < len) {
            int j = i;
            while (j < len && s[j] == '.') {
                j++;
            }
            char right = j < len ? s[j] : 'R';
            if (left == right) {
                while (i < j) {
                    s[i++] = right;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}