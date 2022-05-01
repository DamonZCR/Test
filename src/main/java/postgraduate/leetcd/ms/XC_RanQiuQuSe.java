package postgraduate.leetcd.ms;

import java.util.*;

/** 携程-20220414-第二题
 * 题目描述
 * 游游拿到了一个数组,其中一些数被染成红色,一些数被染成蓝色。游游想知道,取两个不同颜色的数，且它们的数值相等,有多少种不同的取法?
 * 我们定义，两种取法如果取的某个数在原数组的位置不同,则定义为不同的取法。
 * 输入描述:
 * 第一行输入一个正整数n，代表数组的长度。第二行输入n个正整数ai，代表数组中的元素。
 * 第三行输入一个长度为n,仅包含'R’和'B’两种字符的字符串,第i个字符为'R'代表数组第i个元素被染成红色，为'B'代表被染成蓝色。
 *
 * 1 <= n <= 200000
 * 1<= a <= 10^9
 * 输出描述:
 * 5
 * 1 2 1 2 2
 * BRRBB
 * 输出
 * 3
 * 说明
 * 第一种取法,取第一个数和第三个数,颜色不同且都是1。
 * 第二种取法,取第二个数和第四个数,颜色不同且都是2。
 * 第三种取法,取第二个数和第五个数,颜色不同且都是2。
 */
public class XC_RanQiuQuSe {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        String s = sc.next();
        /*System.out.println(Arrays.toString(nums));
        System.out.println(s);*/

        HashMap<Integer, Integer> mapR = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'B'){
                if (mapB.getOrDefault(nums[i], 0) == 0){
                    mapB.put(nums[i], 1);
                }else {
                    mapB.put(nums[i], mapB.get(nums[i]) + 1);
                }
            }else {
                if (mapR.getOrDefault(nums[i], 0) == 0){
                    mapR.put(nums[i], 1);
                }else {
                    mapR.put(nums[i], mapR.get(nums[i]) + 1);
                }
            }
        }
        int size = mapB.size();
        Set<Map.Entry<Integer, Integer>> entries = mapB.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            Integer mapRVal = mapR.getOrDefault(key, 0);
            res += mapRVal * value;
        }
        System.out.println(res);
    }
}
