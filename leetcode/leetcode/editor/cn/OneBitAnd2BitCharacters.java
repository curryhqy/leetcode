package editor.cn;

public class OneBitAnd2BitCharacters{
    public static void main(String[] args) {
        Solution solution = new OneBitAnd2BitCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int flag = 0;
        while (flag < len - 1) {
            flag += bits[flag] + 1;
        }
        return flag == len - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}