package editor.cn;

public class SortedMergeLcci{
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1;
        int pb = n - 1;
        int tail = m + n - 1;
        while (pa >= 0 && pb >= 0) {
            if (A[pa] >= B[pb]) {
                A[tail--] = A[pa--];
            } else {
                A[tail--] = B[pb--];
            }
        }
        if (pb >= 0) {
            while (pb >= 0) {
                A[tail--] = B[pb--];
            }
        }
        if (pa >= 0) {
            while (pa >= 0) {
                A[tail--] = A[pa--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}