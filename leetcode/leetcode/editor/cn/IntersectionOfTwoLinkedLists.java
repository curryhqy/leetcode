package editor.cn;

import editor.cn.doc.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //方法1：哈希表
//        Set<ListNode> vis = new HashSet<>();
//        while (headA != null) {
//            vis.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (vis.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
        //方法2：重走走对方的路
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pathA = headA;
        ListNode pathB = headB;
        while (pathA != pathB) {
            pathA = pathA == null ? headB : pathA.next;
            pathB = pathB == null ? headA : pathB.next;
        }
        return pathA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}