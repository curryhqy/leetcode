package editor.cn;

import editor.cn.doc.ListNode;

public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //保存链表
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;

        //1.找到left
        for (int i = 0; i < left - 1; i++) {
            //pre为left前一个节点
            pre = pre.next;
        }
        ListNode rightNode = pre;
        //2.找到right
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //3.断开left - right
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        rightNode.next = null;
        pre.next = null;
        //4.反转left - right
        ListNode[] reverse = reverse(leftNode, rightNode);

        //5.接回原链表
        pre.next = reverse[0];
        reverse[1].next = curr;

        return dummyNode.next;
    }

    private ListNode[] reverse(ListNode leftNode, ListNode rightNode) {
        ListNode pre = new ListNode();
        pre.next = leftNode;
        ListNode cur = leftNode;
        rightNode.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {rightNode, leftNode};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}