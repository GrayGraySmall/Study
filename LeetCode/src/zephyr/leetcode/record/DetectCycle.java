package zephyr.leetcode.record;

import zephyr.leetcode.common.ListNode;

/**
 * 142. Linked List Cycle II (Medium)
 * 题目描述
 * 给定一个链表，如果有环路，找出环路的开始点。
 * 3.5 滑动窗口 – 11/143 –
 * 输入输出样例
 * 输入是一个链表，输出是链表的一个节点。如果没有环路，返回一个空指针。
 * 图 3.1: 题目 142 - 输入样例
 * 在这个样例中，值为 2 的节点即为环路的开始点。
 * 如果没有特殊说明，LeetCode 采用如下的数据结构表示链表。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (fast != slow);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = new ListNode();
        listNode.value = 3;
        ListNode listNode1 = new ListNode();
        listNode1.value = 2;
        ListNode listNode2 = new ListNode();
        listNode2.value = 0;
        ListNode listNode3 = new ListNode();
        listNode3.value = -4;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        System.out.println(detectCycle.detectCycle(listNode).value);
    }
}
