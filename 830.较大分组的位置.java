import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = s.length();
        int num = 1;
        for (int i = 0; i < len; i++) {
            if (i == len-1 || s.charAt(i) != s.charAt(i+1)) {
                if (num >= 3) {
                    ans.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ans;
    }
}