import java.util.HashMap;
import java.util.Map;

public class Sword35 {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            //map中存的是(原节点，拷贝节点)的一个映射
            Map<Node, Node> map = new HashMap<>();
            for (Node cur = head; cur != null; cur = cur.next) {
                map.put(cur, new Node(cur.val));
            }
            //将拷贝的新的节点组织成一个链表
            for (Node cur = head; cur != null; cur = cur.next) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
            }
            return map.get(head);
        }
    }
