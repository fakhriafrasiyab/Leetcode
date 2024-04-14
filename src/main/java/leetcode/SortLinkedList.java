package leetcode;

import java.util.Random;

public class SortLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode getMid(ListNode head) {
        ListNode midPrev=null;
        while (head != null && head.next != null) {
            midPrev = (midPrev==null) ? head : midPrev.next;
            head=head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next=null;
        return mid;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }


    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode bosGosterici = new ListNode();
        ListNode quyruq = bosGosterici;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                quyruq.next = list1;
                list1 = list1.next;
                quyruq = quyruq.next;
            } else {
                quyruq.next = list2;
                list2 = list2.next;
                quyruq = quyruq.next;
            }
        }
        quyruq.next = (list1 != null) ? list1 : list2;
        return bosGosterici.next;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ListNode head = new ListNode(random.nextInt(10));
        ListNode current = head;
        for (int i = 0; i < 5; i++) {
            ListNode newNode = new ListNode(random.nextInt(10));
            current.next = newNode;
            current = current.next;
        }
        sortList(head);
    }
}
