## 剑指Offer

#### 剑指Offer 03

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        for (int num : nums) {
            if (flag[num]) {
                return num;
            } else{
                flag[num] = true;
            }
        }
        return 0;
    }
}
```



#### 剑指Offer 04

```java
//站在右上角看。这个矩阵其实就像是一个Binary Search Tree。然后，聪明的大家应该知道怎么做了。
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int curRow = 0, curCol = col - 1;
        while (curRow < row && curCol >=0){
            if (matrix[curRow][curCol] == target){
                return true;
            }else if (matrix[curRow][curCol] < target){
                curRow++;
            }else {
                curCol--;
            }
        }
        return false;
    }
}
```



#### 剑指Offer 06 

```java
// 注意边界值就好
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
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
```



#### 剑指Offer 18

```java
// 利用了两个指针记录
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curr = head;
        ListNode pre = new ListNode(-1);
        if (head.val == val)
            return head.next;
        while (curr != null){
            if (curr.val == val){
                pre.next = curr.next;
              	break;
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }
}
```





#### 剑指Offer 22

```java
// 典型的双指针问题
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        for (int i = 1; i < k; i++) {
            p1 = p1.next;
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
```



#### 剑指Offer 24

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;            
        }
        return pre;
    }
}
```



#### 剑指Offer 29

```java
class Solution {
    // 第一位表示行变化，第二位表示列变化
    // 0代表不变，1代表增加，-1代表减少
    // 四行分别代表：右，下，左，上
    int[][] d = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0)
            return new int[0];
        int m = matrix[0].length;
        int[] res = new int[n * m];
        boolean[][] vis = new boolean[n][m];
        int r = 0, c = 0;
        int index = 0;
        // 初始化 方向。往左
        int dir = 0;
        while (index < n * m) {
            res[index++] = matrix[r][c];
            // 标记当前点已经访问过
            vis[r][c] = true;
            int nextR = r + d[dir % 4][0];
            int nextC = c + d[dir % 4][1];
            // 边界判断
            // 最外圈，0 <= nextR < n-1，0 <= nextC <= m-1
            // 其余位置根据vis数据判断，只要访问过就算达到边界
            if (nextR == n || nextR < 0 || nextC == m || nextC < 0 || vis[nextR][nextC]) {
                // 达到边界转方向
                dir += 1;
                nextR = r + d[dir % 4][0];
                nextC = c + d[dir % 4][1];
            }
            // 更新当前点
            r = nextR;
            c = nextC;
        }
        return res;
    }
}
```



#### 剑指Offer 48

```java
// 哈希表解法，滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            // 如果当前出现重复字母，窗口左指针右移到重复字母上次出现的右一位
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end))+1, start);
            }
            // 不断更新的窗口长度与原来所求结果的最大值
            ans = Math.max(ans, end - start + 1);
            // 将出现字母与最新出现的位置存入HashMap
            map.put(s.charAt(end), end);
        }
        return ans;
    }
}
```



#### 剑指Offer 50

```java
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            //getOrDefault意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            //此处存入的是每个元素出现的次数
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 按照字符出现顺序，查找出现近一次的字符。用foreach 顺序不对
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return ' ';
    }
}
```



#### 剑指Offer 52

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //判断两个指针所指节点的值是否相同，若不相同则执行循环语句
        //总体思路是指针各自遍历一遍链表，遍历完成后，然后遍历另一条链表，当指针指向同一元素时，表明此处为相交节点
        //若无相交节点，则遍历完两条链表，pA与pB都为null，跳出循环
        while(pA != pB) {
            //若pA为空，则pA指向headB，否则指向下一点
            pA = pA == null ? headB : pA.next;
            //若pB为空，则pB指向headA，否则指向下一点
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
```



#### 剑指Offer 53 - 1

```java
class Solution {
    public int search(int[] nums, int target) {
        // 非空判断
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        // 二分查找
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while(low <= high) {
            if(nums[mid] == target) {
                ans = count(nums, mid, target);
                break;
            }
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return ans;
    }

    // 向两边扩张计算出个数
    private int count(int[] nums, int cur, int target){
        int l = cur - 1, h = cur + 1;
        int ans = 1;
        while(l >= 0 && nums[l] == target) {
            l--;
            ans++;
        }
        while(h < nums.length && nums[h] == target) {
            h++;
            ans++;
        }
        return ans;
    }
}
```



#### 剑指Offer 53 - 2

```java
class Solution {
    public int missingNumber(int[] nums) {
        // 二分法，最后返回low或者high都可
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}

// 理论的和减去实际的和即为缺少的数字
class Solution {
    public int missingNumber(int[] nums) {
        //计算出0-n的和  n*(n+1)/2
        int sum = nums.length * (nums.length+1)/2;
        return  sum - Arrays.stream(nums).sum() ;
    }
}
```

### 

