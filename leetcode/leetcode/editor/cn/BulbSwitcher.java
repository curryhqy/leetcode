package editor.cn;

public class BulbSwitcher{
    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bulbSwitch(int n) {
        //1~n 完全平方数的个数
        return (int) Math.sqrt(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}