import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num :nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] arr = new int[list.size()];
        int index = 0;
        for (int num : list) {
            arr[index++] = num;
        }
        return arr;
    }
}
// @lc code=end

