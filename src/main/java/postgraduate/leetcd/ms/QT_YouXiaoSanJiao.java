package postgraduate.leetcd.ms;

import java.util.Arrays;
import java.util.HashSet;

/**其他公司-20220320
 * 给定个正整数(0<n<100) ，每个数代表三角形的边长,求用这n个数可以组成多少个不同的三角形。
 * 三边长分别相等的，视为同一个三角形。
 * 例如输入:2,3，4, 2可以组成两个三角形，分别是: 2 3 4 / 2,3,2
 * 输出2
 *
 * 解题思路：
 *  对于正整数 a,b,c，它们可以作为三角形的三条边，当且仅当：
 * a + b > c && a + c > b && b + c > a
 * 均成立。如果我们将三条边进行升序排序，使它们满足 a≤b≤ca，那么 a+c>b和 b+c>a使一定成立的，我们只需要保证 a+b>c。
 * 因此，我们可以将数组 nums进行升序排序，随后使用二重循环枚举 a和 b。设 a=nums[i],b=nums[j]，为了防止重复统计答案，
 * 我们需要保证 i<j。剩余的边 c 需要满足 c<nums[i]+nums[j]，我们可以在 [j+1,n−1]的下标范围内使用二分查找（其中 n
 * 是数组 nums的长度），找出最大的满足 nums[k]<nums[i]+nums[j]的下标 k，这样一来，在 [j+1,k]范围内的下标都可以作
 * 为边 c的下标，我们将该范围的长度 k−j累加入答案。
 * 怎么取出重复的三角形，使用set集合；
 */

public class QT_YouXiaoSanJiao {
    public static void main(String[] args) {
        int[] nums = {2,3,4,2};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>(); 
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                // 二分查找寻找，最大的满足
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                sb.append(nums[i]);sb.append("-");sb.append(nums[j]);sb.append("-");;
                sb2 = sb;
                for (int l = j + 1; l <= k ; l++) {
                    set.add(sb2.append(nums[l]).toString());
                    sb2 = sb;
                }
                sb = new StringBuilder();
            }
        }
        return set.size();
    }
}
