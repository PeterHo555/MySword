public class Sword04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 评论区大神真滴强
        // "提一个不太有人讲的观点，站在右上角看。这个矩阵其实就像是一个Binary Search Tree。然后，聪明的大家应该知道怎么做了。"
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
            System.out.println(matrix[curRow][curCol]);
        }
        return false;
    }
}
