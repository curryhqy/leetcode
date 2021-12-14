package editor.cn;

import editor.cn.doc.ListNode;

public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        
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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
//        int mid = (right + left) >> 1;
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                head.next = a;
                a = a.next;
            } else {
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }
        head.next = (a == null ? b : a);
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}