public class Sword24 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        // 使用临时节点进行交换，实际上就是改变每个节点指的方向，并将原末尾节点置为头节点
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
//        ListNode pre = null;
//        ListNode cur = head;
//        ListNode next = cur.next;
//        while (cur != null){
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
    }
}
