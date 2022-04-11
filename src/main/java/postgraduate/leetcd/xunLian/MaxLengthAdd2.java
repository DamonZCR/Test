package postgraduate.leetcd.xunLian;

import java.util.Scanner;

/**重要：理解双指针思想。
 * 给定一个数组arr，该数组无序，但每个值都是正数，再给定一个正数k, 求arr的所有子数组中所有元素相加和为K的最长子数组长度。
 * 思路：两个变量left和right标记子数组左右两头，开始left = 0，right = 0
 * 1.开始时变量left = 0， right = 0，代表子数组arr[left…right].
 * 2.变量sum始终表示子数组arr[left…right]的和。开始时sum = arr[0], 即arr[0…0]的和。
 * 3.变量len一直记录累加和为k的所有子数组中最大子数组的长度。开始时，len = 0.
 * 4.根据sum 与 k 的比较结果决定left和right移动，具体如下：
 *     如果sum == k, 说明arr[left…right]累加和为k，如果arr[left…right]长度大于len, 则更新len，并令left+1，sum -=arr[left],sum开始表示arr[left+1…right]的累加和。
 *     如果sum < k,令right+1，sum += arr[right]。
 *     如果sum > k,令left+1，sum-=arr[left]。
 * 5.如果right < arr.length, 重复步骤4.否则直接返回len, 全部过程结束。
 */
public class MaxLengthAdd2 {
    public static void main(String[] args) {
        Scanner innum = new Scanner(System.in);
        int length = innum.nextInt();
        int k = innum.nextInt();
        int[] s = new int[length];
        for(int i=0;i<length;i++){
            s[i] = innum.nextInt();
        }
        System.out.println(maxLength(s, k));
    }

    public static int maxLength(int[] arr, int k) {
        if (arr.length == 0 || arr == null || k <= 0) {
            return 0;
        }
        int len = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        sum = arr[0];
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }

}
