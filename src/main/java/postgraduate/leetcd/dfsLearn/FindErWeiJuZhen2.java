package postgraduate.leetcd.dfsLearn;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 例子：
 * 输入：matrix = [
 * [1,4,7,11,15],
 * [2,5,8,12,19],
 * [3,6,9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]], target = 5
 * 输出：true
 */
public class FindErWeiJuZhen2 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {5},
                {6}},
                6));
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了5.79%的用户
     * 内存消耗：47.2 MB, 在所有 Java 提交中击败了55.68%的用户
     * 通过测试用例：129 / 129
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        return dfs(matrix, 0,matrix[0].length - 1, matrix.length - 1, target);
    }

    private static boolean dfs(int[][] matrix, int start, int up, int left, int target) {
        if (start == matrix.length)
            return false;

        for (int i = start; i <= up && start < matrix.length;i++){
            if (matrix[start][i] == target)
                return true;
            if (matrix[start][i] > target){
                up = i - 1;
                break;
            }
        }
        for (int i = start; i <= left && start < matrix[0].length; i++){
            if (matrix[i][start] == target)
                return true;
            if (matrix[i][start] > target){
                left = i - 1;
                break;
            }
        }
        return dfs(matrix, start + 1,up, left, target);
    }
}
