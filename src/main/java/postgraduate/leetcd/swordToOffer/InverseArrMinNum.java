package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class InverseArrMinNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        int[] nums = new int[s.length];
        for(int i = 0;i < s.length;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findMinNum(nums));
    }

    private static int findMinNum(int[] numbers) {
        /**自写代码。
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了93.42% 的用户
         * 通过测试用例：192 / 192
         * 思想：如果只有一个元素，最小元素肯定是它。那么假设这个数组是被旋转过的，
         * 旋转过的总会出现前一个元素比后一个大，找到这个一个元素返回，for循环就是做这样的工作，
         * 如果没有找到前一个比后一个大，说明这个数组没被旋转过，就返回第一个元素即可。
         */
        if (numbers.length == 1)
            return numbers[0];
        for (int i = 0;i < numbers.length;i++){
            if (i < numbers.length - 1) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            } else if (numbers[i] < numbers[i - 1])
                return numbers[i];
        }
        return numbers[0];
    }
}
