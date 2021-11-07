package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**剑指 Offer 03. 数组中重复的数字
 *找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeateNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        int[] nums = new int[s.length];
        for(int i = 0;i < s.length;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int res = findRepeatNumber(nums);
        System.out.println(res);
    }

    private static int findRepeatNumber(int[] nums) {
        /**
         * 执行结果：
         * 通过
         * 执行用时：10 ms, 在所有 Java 提交中击败了8.54% 的用户
         * 内存消耗：47.3 MB, 在所有 Java 提交中击败了32.69% 的用户
         * 通过测试用例：25 / 25
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int fre = map.getOrDefault(nums[i], 0);
            if (fre == 0)
                map.put(nums[i], 1);
            else
                return nums[i];
        }
        return 0;
    }
}
