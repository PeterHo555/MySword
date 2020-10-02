public class Sword12 {

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
