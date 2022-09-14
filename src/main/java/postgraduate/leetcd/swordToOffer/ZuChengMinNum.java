package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 45. 把数组排成最小的数
 *输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *      输入: [10,2]
 *      输出: "102"
 * 示例 2:
 *      输入: [3,30,34,5,9]
 *      输出: "3033459"
 * 提示:
 *      0 < nums.length <= 100
 * 说明:
 *      输出结果可能非常大，所以你需要返回一个字符串而不是整数
 *      拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 解题思路：
 * 此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 xx 和 yy ，则规定 排序判断规则 为：
 *
 * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
 * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；
 * xx “小于” yy 代表：排序完成后，数组中 xx 应在 yy 左边；“大于” 则反之。
 *
 * 根据以上规则，套用任何排序方法对 numsnums 执行排序即可。排序的话就是改写快速排序，改写规则就需要对字符串的数字排序；
 */
public class ZuChengMinNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        System.out.println(minNumber(num));
    }
    public static String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder s = new StringBuilder();
        for (String strs :
                str) {
            s.append(strs);
        }
        return s.toString();
    }
    public static void quickSort(String[] arr,int left,int right) {
        int pivot = 0;
        if(left < right) {
            pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
//0 9 8 7 6 5 4 3 2 1
    private static int partition(String[] arr, int left, int right) {
        String key = arr[left];
        int i = left, j = right;
        while(i < j) {
            while(i < j && (arr[j] + arr[left]).compareTo(arr[left] + arr[j]) >= 0) {
                j--;
            }
            while(i < j && (arr[i] + arr[left]).compareTo(arr[left] + arr[i]) <= 0) {
                i++;
            }
            key = arr[i];
            arr[i] = arr[j];
            arr[j] = key;
        }
       arr[i] = arr[left];
        arr[left] = key;
        return i;
    }
}
