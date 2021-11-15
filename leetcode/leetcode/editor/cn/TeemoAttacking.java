package editor.cn;

public class TeemoAttacking{
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int index = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= index) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - index;
            }
            index = timeSeries[i] + duration;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}