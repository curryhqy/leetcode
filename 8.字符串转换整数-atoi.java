import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        AutoMotan autoMotan = new AutoMotan();
        for (int i = 0; i < len; i++) {
            autoMotan.get(s.charAt(i));
        }
        return (int) (autoMotan.sign * autoMotan.ans);
    }
}

class AutoMotan {
    public int sign = 1;
    public long ans = 0;

    private String state = "start";
    private Map<String, String[]> table = new HashMap<>() {
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };
    
    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = (sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) 
                : Math.min(ans, -(long) Integer.MIN_VALUE));
        } else if ("signed".equals(state)) {
            sign = (c == '+' ? 1 : -1);
        }
    }

    public int getCol(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }
}
// @lc code=end

