package postgraduate.leetcd.xunLian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 未排序正数数组中累加和为给定值的最长子数组的长度.
 * 给定一个数组arr,该数组无序，但每个值均为正数，再给定一个正数k。 求arr的所
 * 有子数组（连续的）中所有元素相加和为k的最长子数组的长度。
 * 例如，
 * arr=[1,2,1,1,1],k=3累加和为3的最长子数组为[1, 1, 1]，所以结果返回3
 * [要求]
 * 时间复杂度为O(n),空间复杂度为0(1)
 * 输入描述
 * 第一行两个整数N, k。N表示数组长度，k的定义已在题目描述中给出第二行N个整数表示数组内的数。
 *算法关键：
 *     arr[j…i]=s(i)-s(j-1)。找到一个sum.这个sum 存在并且还存在sum-k也存在。
 *   Map保留了每一次得出的sum和sum出现的位置标记。使用len来记录最大的距离。
 *为什么要首先添加一个put(0,-1)?
 *      arr[j+1…i]=s(i)-s(j)，所有从0位置开始的子数组都没有考虑过。所以，
 *    应该从-1位置开始累加，也就是在遍历之前先把（0，-1）这个记录放进map，
 *    这个记录的意思是如果任何一个数也不加时，累加和为0。比如arr=[1,2,3,3],k=6，
 *    如果从0位置开始累加，也就是遍历之前不加入（0，-1）这条记录，那么当遍历到
 *    第一个3时，sum=6，map中记录为（1,0）（3,1），此时sum-k=6-6=0，当在map中
 *    查询累加和0最早出现的位置，，发现没有出现过，那么子数组[1,2,3]就被我们忽略。
 *    所以遍历之前需要先加入（0，-1）这条记录。
 */
public class MaxLengthAdd {
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
        if(arr==null||arr.length==0)
            return 0;
        //map，key表示从arr最左边开始累加的过程中出现过的sum值，对应的value值则表示sum值最早出现的位置
        Map<Integer,Integer> map=new HashMap();
        map.put(0, -1);
        int sum=0,len=0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            if(!map.containsKey(sum))
                map.put(sum, i);
            if(map.containsKey(sum-k))
                len=Math.max(len, i - map.get(sum - k));
        }
        return len;
    }
}
