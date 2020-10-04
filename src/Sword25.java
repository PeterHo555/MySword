public class Sword25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链表类问题，设置dummyHead是一个常规操作，主要是为了避免讨论头节点，倒不一定是头节点丢失。
        // 这个题如果你不用dummyHead，你就需要去讨论头节点到底是l1还是l2。
        // 而如果是删除倒数第n个节点那个题，如果不采用dummyHead，你就需要单独去讨论如果删除的是倒数第n个节点，也就是head被删除的情况。
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummyHead.next;
    }
}
