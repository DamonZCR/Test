package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 53 - II. 0～n-1中缺失的数字
 *一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 示例 3:
 * 输入: [0]
 * 输出: 1
 * 1 <= 数组长度 <= 10000
 */
public class FindLostNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");// 输入这个数组
        int[] nums = new int[s.length];
        for(int i = 0;i < s.length;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int res = findlostNum(nums);
        System.out.println(res);
    }
    // 使用折半查找的思维
    private static int findlostNum(int[] nums) {
        /**
         * 因为是顺序数组，折半时中间位置总是固定的，如果中间位置的数字不是应该得到的对应数字，
         * 说明这个前区间缺少数字，在进行折半缩短区间。
         */
        //判断两端
        if(nums[0] != 0)
            return 0;
        if (nums[nums.length - 1] != nums.length)
            return nums.length;

        int from = 0;
        int end = nums.length - 1;
        int mid = 0;

        while(from <= end){
            mid = (from + end) / 2;
            if (mid == nums[mid]){
                from = mid + 1;
            }else if (mid < nums[mid]){
                //折半的位置会不会就是缺少的这个数字？
                //那么判断：上边的if已经判断当折半的位置的数大于数组此位置数
                //在用下边判断数组位置的下一个小于它即可。
                if (nums[mid-1] == mid - 1)
                    return mid;
                end = mid - 1;
            }
        }
        return 0;
    }
}
