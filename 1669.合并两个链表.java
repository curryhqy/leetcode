/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        for (int i = 0; i < a - 1; i++) {
            node = node.next;
        }
        ListNode node1 = node.next;
        for (int i = 0; i < b - a + 1; i++) {
            node1 = node1.next;
        }
        node.next = list2;
        while (node.next != null) {
            node = node.next;
        }
        node.next = node1;
        return list1;
    }
}
// @lc code=end

