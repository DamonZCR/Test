package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 返回数组中缺少的最小的正整数
 * 给定一个包含 N 个整数的数组 A，返回 A 中未出现的最小正整数（大于 0）。
 * 例如，给定 A = [1, 3, 6, 4, 1, 2]，函数应该返回 5。
 * 给定 A = [1, 2, 3]，函数应该返回 4。
 * 给定 A = [−1, −3]，该函数应返回 1。
 * 为以下假设编写一个有效的算法：
 *  N 是 [1..100,000] 范围内的整数；
 *
 *  数组 A 的每个元素都是 [−1,000,000..1,000,000] 范围内的整数。
 */
public class MinInt {
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));//5
        //System.out.println(solution(new int[]{-1, -3}));//1
        System.out.println(solution(new int[]{1, 2, 3}));//4
    }
    public static int solution(int[] A){
        List<Integer> ints = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        ArrayList<Integer> list = new ArrayList(ints);
        int min = 1;
        int last = 0;

        for (int i = 0;i < A.length;i++){
            if (min == list.get(i)){
                if (min != last){
                    last = min;
                    min++;
                }
            }
        }
        return min;
    }
}
