/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode res = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prehead.next = l1;
                l1 = l1.next;
            } else {
                prehead.next = l2;
                l2 = l2.next;
            }
            prehead = prehead.next;
        }
        prehead.next = (l1 == null ? l2 : l1);
        return res.next;
    }
}
// @lc code=end

