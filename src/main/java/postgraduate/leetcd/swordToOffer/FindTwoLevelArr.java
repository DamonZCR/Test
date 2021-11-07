package postgraduate.leetcd.swordToOffer;

/**剑指 Offer 04. 二维数组中的查找
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */

public class FindTwoLevelArr {
    public static void main(String[] args) {

    }
    private static boolean findTwoLevelArr(int[][] matrix, int target){
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int hang = 0;
        int lie = 0;
        // 以下两个for循环是找到这个数最有可能出现的列和行
        for (;hang <= matrix[0].length - 1;hang++){
            // 求出应该在哪一个列中，例如5，就可以确定5在序号1列以内。
            if (target < matrix[0][hang]){
                if (hang > 0)
                    hang--;
                break;
            }
            if (hang == matrix[0].length - 1)
                break;
        }
        for (;lie <= matrix.length - 1;lie++){
            // 求出应该在哪一个行中，例如5，就可以确定5在序号1行以内。
            if (target < matrix[lie][0]){
                if (lie > 0)
                    lie--;
                break;
            }
            if (lie == matrix.length - 1)
                break;
        }

        // 遍历行
        for (int i = 0;i <= lie;i++){
            if (matrix[i][hang] == target)
                return true;
        }
        // 遍历列
        for(int j = 0;j <= hang;j++){
            if (matrix[lie][j] == target){
                return true;
            }
        }
        // 对最小的矩阵进行遍历，如果这一行出现比target大的，直接到下一行
        for(int i = lie - 1;i >= 0;i--){
            for (int j = 0;j < hang;j++){
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    break;
            }
        }
        return false;

    }
}
