package postgraduate.leetcd.xunLian;

/**
 * 对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。 给定一个整数数组A及它的大小n，请返回最短子数组的长度。
 * 要求：时间复杂度O(n) 空间复杂度O(1)
 * 例子： [1,5,3,4,2,6,7]
 * 返回：4
 * 解题思路：
 * 数组如果有序一定有左边的数字一定小于右边的数字。那么：
 * 1. 从左往右找”当前值比max小”的一系列情况：
 * 初始：max=arr[0]；
 * 如果当前元素比max大，max就等于当前元素；
 * 如果当前元素比max小，max不变，然后继续往后找,直到最后一次出现”当前值比max小”的情形，记下此时的下标为k。
 * 2. 从右往左找”当前值比min大”的一系列情况：
 * 初始：min=arr[6];
 * 如果当前元素比min小，min就等于当前元素；
 * 如果当前元素比min大，min不变，然后继续往前找，直到最后一次出现就”当前值比min大”的情形，记下此时的下标为j。
 * 3. 长度=k-j+1。
 */
public class MinLenthArr {
    public static int getMinLengthForSort(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;   // 不需要排序
        }

        int maxLeft = arr[0];  // 左边最大
        int minRight = arr[arr.length - 1];  // 右边最小
        // 这两个指针分别记录左右两边无效的位置
        int invalidLeft = 0;
        int invalidRight = -1;  // 数组原本有序时：invalidRight - invalidLeft + 1 = 0
        // 1、从左到右遍历：找出不合适数的最右范围
        // 遍历过的最大值大于当前值，那么当前值肯定是无效的，那么排序时这个最大值在当前位置或者是更右的位置
        for(int i = 1; i < arr.length; i++){
            if(maxLeft > arr[i]){
                // 如果已经遍历过的最大值大于当前值，则记录最右边无效位置
                invalidRight = i;
            }else{
                // 如果已经遍历过的最大值小于等于当前值，则遍历过的最大值更新为当前值
                maxLeft = arr[i];
            }
        }
        // 2、从右向左遍历：找出不合适数的最左范围
        // 遍历过的最小值小于当前值，那么当前值就是无效的，那么排序时这个最小值在当前位置或者是更左的位置
        for(int i = arr.length - 2; i >= 0; i--){
            if(minRight < arr[i]){
                // 如果已经遍历的最小值小于当前值，则记录最左边无效的位置
                invalidLeft = i;
            }else{
                // 更新最小值
                minRight = arr[i];
            }
        }
        // invalidRight是不合适数的最右范围，invalidLeft 是不合适数的最左范围
        // invalidRight - invalidLeft + 1 就是不合适数的个数
        return invalidRight - invalidLeft + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2,6,7};
        System.out.println(getMinLengthForSort(arr));
    }
}