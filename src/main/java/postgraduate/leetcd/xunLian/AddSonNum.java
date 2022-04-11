package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**ID：523 连续子数组
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *     1、子数组大小 至少为 2 ，且
 *     2、子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 */
public class AddSonNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        int[] nums = new int[s.length];
        for(int z = 0;z < s.length; z++){
            nums[z] = Integer.parseInt(s[z]);
        }
        System.out.println(solve(nums, k));
        System.out.println(solve2(nums, k));
    }

    // 方法一：自写，通过 97% 的测试用例，剩下超过几千个数的数组运行超时。
    private static boolean solve(int[] nums, int k) {
        /**思路
         * 计算数组的前缀和，将序号作为键，将前缀和作为值，如：2，3，4，5那么序号键2的值为9.
         * 然后判断当遍历到子数组长度大于等于时，是否前缀和为k 的倍数，如果是返回True。
         * 否则，从当前位置向前跨两个长度的位置，遍历当前位置的前缀和 减去 访问位置的前缀和 是否为k 的倍数。
         */
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int i = 0;
        int adds = 0;
        while (i < nums.length){
            adds += nums[i];
            map.put(i, adds);
            if (i > 0 && map.get(i) % k == 0)
                return true;
            for (int j = i - 2;0 <= j;j--){
                if ((map.get(i)- map.get(j)) % k == 0)
                    return true;
            }
            i++;
        }
        return false;
    }
    private static boolean solve2(int[] nums, int k){
        /**
         * 如果事先计算出数组 nums的前缀和数组，则对于任意一个子数组，都可以在 O(1)的时间内得到其元素和。用prefixSums[i] 表示数组 nums 从下标0 到下标i 的前缀和，
         * 则nums 从下标p+1 到下标q（其中p<q）的子数组的长度为q−p，该子数组的元素和为prefixSums[q]−prefixSums[p]。
         * 如果prefixSums[q]−prefixSums[p] 为k 的倍数，且q−p≥2，则上述子数组即满足大小至少为2 且元素和为k 的倍数。
         * 当prefixSums[q]−prefixSums[p] 为k 的倍数时，prefixSums[p] 和 prefixSums[q] 除以k 的余数相同。因此只需要计算每个下标对应的前缀和除以k 的余数即可，
         * 使用哈希表存储每个余数第一次出现的下标。规定空的前缀的结束下标为 −1，由于空的前缀的元素和为 0，因此在哈希表中存入键值对 (0,−1)。对于i<m0≤i<m，从小到大依次遍历每个 i，
         * 计算每个下标对应的前缀和除以 k的余数，并维护哈希表：
         *     如果当前余数在哈希表中已经存在，则取出该余数在哈希表中对应的下标 prevIndex,nums 从下prevIndex+1 到下标i 的子数组的长度为i−prevIndex，
         *          该子数组的元素和为k 的倍数，如果i−prevIndex≥2，则找到了一个大小至少为2 且元素和为k 的倍数的子数组，返回 true；
         *     如果当前余数在哈希表中不存在，则将当前余数和当前下标 i 的键值对存入哈希表中。
         * 由于哈希表存储的是每个余数第一次出现的下标，因此当遇到重复的余数时，根据当前下标和哈希表中存储的下标计算得到的子数组长度是以当前下标结尾的子数组中满足元素和为
         * k的倍数的子数组长度中的最大值。只要最大长度至少为 2，即存在符合要求的子数组。
         */
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
