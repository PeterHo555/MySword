## 剑指Offer笔记

[toc]

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
// 站在右上角看。这个矩阵其实就像是一个Binary Search Tree。然后，聪明的大家应该知道怎么做了。
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



#### 剑指Offer 07（重构二叉树）

```java

```



#### 剑指Offer 12 （矩阵单词查找）

```java
class Solution {
    private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length ==0)
            return false;
        row = board.length;
        col = board[0].length;

        boolean[][] vis = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dfs(0, r, c, vis, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int curLen, int r, int c, boolean[][] vis, char[][] board, String word){
        // 长度相等return true
        if (curLen == word.length())
            return true;
        // 边界过滤条件
        // 判断单词的此位是否相等
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(curLen) || vis[r][c]) {
            return false;
        }
        // 标记为已访问
        vis[r][c] = true;
        // 对四个方向回溯
        for (int[] d : direction){
            if (dfs(curLen + 1, r + d[0], c + d[1], vis, board, word))
                return true;
        }
        // 下一步要return，所以要除去访问标记
        vis[r][c] = false;
        return false;
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



#### 剑指Offer 26（树的子结构）

```java

```



#### 剑指Offer 27（树的镜像）

```java
// 递归，注意一下其他的方法，用栈或队列
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;//后面的操作会改变 left 指针，因此先保存下来
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tempLeft);
        return root;
    }
}
```



#### 剑指Offer 28（树的对称）

>做递归思考三步：
>
>1. 递归的函数要干什么？
>
>- 函数的作用是判断传入的两个树是否镜像。
>- 输入：TreeNode left, TreeNode right
>- 输出：是：true，不是：false
>
>2. 递归停止的条件是什么？
>
>- 左节点和右节点都为空 -> 倒底了都长得一样 ->true
>- 左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
>- 左右节点值不相等 -> 长得不一样 -> false
>
>3. 从某层到下一层的关系是什么？
>
>- 要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
>- 调用递归函数传入左左和右右
>- 调用递归函数传入左右和右左
>- 只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
>
>4. 调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null

```java
// 递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
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



#### 剑指Offer32-1

```java
// 就一个层次遍历，不是很懂为什么是medium
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            ansList.add(node.val);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
```



#### 剑指Offer32-2

```java
// 自己的方法用了两个队列
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                tempQueue.add(queue.poll());
            }
            while (!tempQueue.isEmpty()){
                if (tempQueue.peek().left != null)
                    queue.add(tempQueue.peek().left);
                if (tempQueue.peek().right != null)
                    queue.add(tempQueue.peek().right);
                list.add(tempQueue.poll().val);
            }
            ansList.add(new ArrayList<>(list));
        }
        return ansList;
    }
}
```



#### 剑指Offer32-3

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                tempQueue.add(queue.poll());
            }
            while (!tempQueue.isEmpty()){
                if (tempQueue.peek().left != null)
                    queue.add(tempQueue.peek().left);
                if (tempQueue.peek().right != null)
                    queue.add(tempQueue.peek().right);
                list.add(tempQueue.poll().val);
            }
            ansList.add(new ArrayList<>(list));
        }
      	// 与上一题的主要区别
        for (int i = 1; i < ansList.size(); i += 2) {
            Collections.reverse(ansList.get(i));
        }
        return ansList;
    }
}
```





#### 剑指Offer 34（树的路径和）

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int curSum, List<Integer> list, List<List<Integer>> ans){
        // 节点为空直接返回
        if (root == null)
            return;
        // 将当前节点的值加入到list中
        list.add(root.val);
        // 每往下走一步就要计算走过的路径和
        curSum += root.val;
        // 如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null){
            if (sum == curSum)
                // 此处一定要new
                ans.add(new ArrayList<>(list));
            // 需要将最后加入的节点给移除掉，
            // 因为下一步直接return了，不会再走最后一行的remove了，
            // 所以这里在return之前提前把最后一个结点的值给remove掉。
            list.remove(list.size() - 1);
            return;
        }
        // 如果没到达叶子节点，就继续从他的左右两个子节点往下找
        dfs(root.left, sum, curSum, list, ans);
        dfs(root.right, sum, curSum, list, ans);
        // 我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        // 我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }
}
```





#### 剑指Offer 35（链表拷贝）

>太菜了，没明白题意。
>
>浅拷贝只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。但深拷贝会另外创造一个一模一样的对象，新对象跟原对象不共享内
>
>存，修改新对象不会改到原对象。

```java
class Solution {
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
```



#### 剑指Offer 37（序列化二叉树）

```java

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



#### 剑指Offer 52（相交链表）

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //判断两个指针所指节点的值是否相同，若不相同则执行循环语句
        //总体思路是指针各自遍历一遍链表，遍历完成后，然后遍历另一条链表，当指针指向同一元素时，表明此处为相交节点
        //若无相交节点，则遍历完两条链表，pA与pB都为null，此时 pA == pB，跳出循环
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



#### 剑指Offer 53 - 1（有序数组同一元素的个数）

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



#### 剑指Offer 54（二叉搜索树的倒数第k大节点）

```java
class Solution {
  	// 先中序遍历，存入list，再取倒数第k项
    public int kthLargest(TreeNode root, int k) {
        List<Integer> treeList = new ArrayList<>();
        helper(root, treeList);
        return treeList.get(treeList.size() - k);
    }

    private void helper(TreeNode root, List<Integer> treeList){
        if (root == null) return;
        if (root.left != null) helper(root.left, treeList);
        treeList.add(root.val);
        if (root.right != null) helper(root.right, treeList);
    }
}

// 做了点小变化，反中序遍历，直接得到逆序列
class Solution {
     public int kthLargest(TreeNode root, int k) {
        List<Integer> treeList = new ArrayList<>();
        helper(root, treeList);
        return treeList.get(k - 1);
    }

    private void helper(TreeNode root, List<Integer> treeList){
        if (root == null) return;
        if (root.right != null) helper(root.right, treeList);
        treeList.add(root.val);
        if (root.left != null) helper(root.left, treeList);
    }
}

// 思路同上，但直接return答案，不再用list
class Solution {
    private int ans = 0, cnt = 0;
    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root,  int k){
        if (root == null) return;
        if (root.right != null) helper(root.right, k);
        if (++cnt == k){
            ans = root.val;
        }
        if (root.left != null) helper(root.left, k);
    }
}
```



#### 剑指Offer 55-1（树的深度）

```java
// 递归法
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

//层次遍历，AC速度还不如递归。但是面试可能考
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            // 需要先记录当前层的长度，因为queue.size()会变
            int curSize = queue.size();
            for(int i = 0; i < curSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
```



#### 剑指Offer 55-2（树的平衡）

```java
// 结合55-1的经典递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```



#### 剑指Offer 68-1（二叉搜索树最近公共父节点）

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当p和q节点等于root节点，直接返回root
        if (p.val == root.val || q.val == root.val){
            return root;
        }
        //递归求解，利用二叉搜索树性质，切记
        if (p.val > root.val && q.val > root.val) {//p和q节点都大于root，则说明p和q为root的右子节点
            return lowestCommonAncestor(root.right, p, q);
        }else if (p.val < root.val && q.val < root.val) {//p和q节点都小于root，则说明p和q为root的左子节点
            return lowestCommonAncestor(root.left, p, q);
        }else{//其他情况均为root节点为最大父节点
            return root;
        }
    }
}
```



#### 剑指Offer 68-2（二叉树最近公共父节点）

```java
// 递归解法
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}

// 别人的代码注解
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
}
```

