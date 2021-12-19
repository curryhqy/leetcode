package editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SmallestSubsequenceOfDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() &&
                    lastIndex[stack.peekLast() - 'a'] > i &&
                    stack.peekLast() > charArray[i]) {
                Character ch = stack.removeLast();
                visited[ch - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}