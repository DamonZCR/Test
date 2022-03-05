package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 57. 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 限制：
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^6
 */
public class HeWei_SDeNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int[] a = new int[s.length];
        for (int i = 0;i < s.length;i++){
            a[i] = Integer.parseInt(s[i]);
        }
        System.out.println(solve(a, target));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     *
     * 添加备注
     * 执行用时：6 ms, 在所有 Java 提交中击败了20.72% 的用户
     * 内存消耗：60.6 MB, 在所有 Java 提交中击败了5.05% 的用户
     * 通过测试用例：36 / 36
     * @param nums
     * @param target
     * @return
     */
    public static int[] solve(int[] nums, int target){
        int[] res = new int[2];
        for (int i = 0;i < nums.length;i++){
            // 如果这个数不用加任何数已经大于 target，或者和最大值相加都小于target，就跳出。
            if (nums[i] > target || nums[i] + nums[nums.length - 1] < target)
                continue;
            for (int j = i;j < nums.length;j++){
                if (nums[i] + nums[j] > target)
                    break;
                if (nums[i] + nums[j] == target){
                    res[0] = nums[i];
                    res[1] = nums[j];
                    return res;
                }

            }
        }
        return res;
    }

}
