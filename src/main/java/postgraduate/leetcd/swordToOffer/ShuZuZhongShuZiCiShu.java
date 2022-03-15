package postgraduate.leetcd.swordToOffer;

import java.util.Arrays;

/**剑指 Offer 56 - I. 数组中数字出现的次数
 *一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class ShuZuZhongShuZiCiShu {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] res =  new int[2];

        // 判断当前数组与下一个数组是否相同，相同就连续跳过这两个；
        for (int i = 0,j = 0; i < len; i++) {
            if (i + 1 < len && nums[i] != nums[i + 1]){
                res[j] = nums[i];
                j++;
            }else if (i + 1 < len && nums[i] == nums[i + 1]){
                i++;
            }else {
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }
}
