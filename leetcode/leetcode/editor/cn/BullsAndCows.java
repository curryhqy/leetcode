package editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BullsAndCows{
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        System.out.println(solution.getHint("1807", "7810"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < cntG.length; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}