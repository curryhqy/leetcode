package editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        String leftStr = s.substring(0, n);
        String rightStr= s.substring(n, s.length());
        return rightStr + leftStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}