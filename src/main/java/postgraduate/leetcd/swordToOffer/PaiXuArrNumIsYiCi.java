package postgraduate.leetcd.swordToOffer;

import java.util.HashSet;

/**
 * 有序的数组中，每个数字出现两次，请找出出现1次的数字；
 */
public class PaiXuArrNumIsYiCi {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        //int[] nums = {3,3,7,7,10,11,11};
        //int[] nums = {1,1,2};
        System.out.println(solve2(nums));
    }
    public static int solve(int[] nums){
        /**
         * 执行结果：通过 显示详情 暴力解法
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 41.3 M, 在所有 Java 提交中击败了54.31%的用户
         * 通过测试用例：
         * 14 / 14
         * 暴力解法，当前的数不等于下一个数
         */
        if (nums.length < 2)
            return nums[0];
        for (int i = 0; i < nums.length; i+=2) {
            if (i == nums.length-1 || nums[i]!=nums[i+1])
                return nums[i];
        }
        return 0;
    }
    public static int solve2(int[] nums){
        /**
         * 执行用时：3 ms, 在所有 Java 提交中击败了5.17%的用户
         * 内存消耗：42.3 MB, 在所有 Java 提交中击败了5.07%的用户
         */
        HashSet<Integer> set = new HashSet();
        int len = set.size();
        for (int i = 0; i < nums.length; i++) {
            len = set.size();
            set.add(nums[i]);
            if (len != set.size()){
                if (i + 1 < nums.length && nums[i] !=nums[i+1])
                    return nums[i];
                else if (i+1 >= nums.length)
                    return nums[i];
            }
        }
        return 0;
    }
}
