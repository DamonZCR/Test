package postgraduate.leetcd.xunLian;

/**
 * 问题：
 * 给定一个数组 arr，该数组无序，但每个值均为正数，再给定一个正数 k。
 * 求 arr 的所有子数组中所有元素相加和为 k 的最长子数组长度。 例如，arr=[1,2,1,1,1]，k=3。
 * 累加和为 3 的最长子数组为[1,1,1]，所以结果返回 3。
 * 要求：
 * 时间复杂度 O(N)，额外空间复杂度 O(1)
 * 分析：
 * 我们最容易想到的解法还是暴力，暴力出奇迹~~~找出所有的子数组和为k的，然后再找出其中最长的一个。
 * 时间复杂度为O(N*N)。显然这种解法是不符合题意的。这里我们依然会用到双指针，下面开始我们的解法。
 * 解法：
 * 声明两个变量left（左指针）和right（右指针），初始时这两个指针指向数组第一个元素；
 * 声明变量sum保存遍历时的元素累加和，变量len保存长度。开始遍历，若sum小于k，则right向右滑动一个位置，
 * sum累加当前right指向位置的值；若sum大于k，sum减去当前left所指向位置的值，left向右滑动一个位置；若sum和k的值相等，
 * 则比较len和当前left到right的长度，若left到right的长度大于len的值，则len赋值为left到right的长度。
 * sum减去left指向位置的值，left向右移动一位。当right到达数组最后一个位置算法终止。整个算法过程中，我们只遍历了一遍，
 * 时间复杂度为O(N)，我们只声明了几个辅助变量，额外空间复杂度为O(1)。那么为什么这么做可以得到正确结果呢？
 * 1，left会一直在right前面；2，假设正确的结果在数组中的A部分，那么left只能在A部分前面出现，如果left出现在A部分，
 * 那么left到right的值会小于k，显然是不符合题意的。由上面1,2两点我们可以确定一定可以找到A部分。
 */
public class SetSon {
    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                if ((++right) == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1, 1};
        System.out.println(getMaxLength(a, 3));
    }
}
