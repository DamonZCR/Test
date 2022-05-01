package postgraduate.leetcd.xunLian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** 4. 寻找两个正序数组的中位数-困难题
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class XunZhaoZhengXuArrMidNum {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;

        List<Integer> list1 = new ArrayList(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        List<Integer> list2 = new ArrayList(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        ArrayList<Integer> all = new ArrayList<>(list1.size() + list2.size());
        all.addAll(list1);
        all.addAll(list2);
        Collections.sort(all);
        if (all.size() % 2 == 0 && all.size() != 0){
            res = (double)(all.get(all.size() / 2) + all.get(all.size() / 2 - 1)) / 2.0;
        }else {
            if (all.size() % 2 == 1 && all.size() > 1)
                res = all.get(all.size() / 2);
            else {
                res = all.get(0);
            }
        }
        return res;
    }
}
