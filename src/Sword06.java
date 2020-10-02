public class Sword06 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        // 先计算链表长度
        int len = 0;
        while (node != null){
            node = node.next;
            len++;
        }
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = head.val;
            head = head.next;
        }
        return ans;
    }
}
