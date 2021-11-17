package editor.cn;

public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        char[] res = new char[s.length() * 3];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else {
                res[index++] = c;
            }
        }
        return new String(res, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}