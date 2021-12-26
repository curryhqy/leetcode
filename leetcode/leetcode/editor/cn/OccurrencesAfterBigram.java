package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram{
    public static void main(String[] args) {
        Solution solution = new OccurrencesAfterBigram().new Solution();
        String text = "alice is a good girl she is a good student";
        String first = "is";
        String second = "a";
        System.out.println(solution.findOcurrences(text, first, second).length);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] textToArray = text.split(" ");
        for (int i = 0; i < textToArray.length - 2; i++) {
            if (textToArray[i].equals(first) && textToArray[i+1].equals(second)) {
                list.add(textToArray[i+2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}