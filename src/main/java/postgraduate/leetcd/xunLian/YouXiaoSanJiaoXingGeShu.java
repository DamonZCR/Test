package postgraduate.leetcd.xunLian;

import java.util.Arrays;

/**611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * 示例 1:
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 * 只要满足任意两边之和大于第三边，或任意两边之差小于第三边就可以构成三角形。
 * 解题思路：
 *  对于正整数 a,b,c，它们可以作为三角形的三条边，当且仅当：
 * a + b > c && a + c > b && b + c > a
 * 均成立。如果我们将三条边进行升序排序，使它们满足 a≤b≤c，那么 a+c>b和 b+c>a使一定成立的，我们只需要保证 a+b>c。
 * 因此，我们可以将数组 nums进行升序排序，随后使用二重循环枚举 a和 b。设 a=nums[i],b=nums[j]，为了防止重复统计答案，
 * 我们需要保证 i<j。剩余的边 c 需要满足 c<nums[i]+nums[j]，我们可以在 [j+1,n−1]的下标范围内使用二分查找（其中 n
 * 是数组 nums的长度），找出最大的满足 nums[k]<nums[i]+nums[j]的下标 k，这样一来，在 [j+1,k]范围内的下标都可以作
 * 为边 c的下标，我们将该范围的长度 k−j累加入答案。
 */
public class YouXiaoSanJiaoXingGeShu {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                int k = j;
                while (left <= right){
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]){
                        k = mid;
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
                res += k - j;
            }
        }
        return res;
    }
}
