package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**剑指 Offer 53 - I. 在排序数组中查找数字 I
 *统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class InSortFindNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");// 输入一个数组：5,7,7,8,8,10
        int target = Integer.parseInt(br.readLine());// 输入要查找的目标
        int[] nums = new int[s.length];
        for(int i = 0;i < s.length;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        // System.out.println(search1(nums, target));// 方法一
        System.out.println(search2(nums, target));// 方法二
    }
    // 方法一：通过ArrayList 使用Collections的frequence方法;
    private static int search1(int[] nums, int target) {
        List<Integer> co = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList(co);
        int res = Collections.frequency(list, target);
        return res;
    }

    // 方法二：通过折半查找的方法
    private static int search2(int[] nums, int target){
        int res = 0;
        int begin = 0;
        if (nums.length == 0)
            return 0;
        int end = nums.length - 1;
        int loca = 0;
        while(begin <= end){
            loca = (begin + end) / 2;
            if (nums[loca] > target){
                end = loca - 1;
            } else if(nums[loca] < target){
                begin = loca + 1;
            }else {
                res++;
                break;
            }
        }
        if (res == 0)
            return 0;
        // 从找到这个target的左右两边开始寻找
        for (int i = loca - 1,j = loca + 1;i >= 0 || j < nums.length;i--,j++){
            if (i >= 0 && nums[i] == target){
                res++;
            }
            if (j < nums.length && nums[j] == target){
                res++;
            }
        }
        return res;
    }
}