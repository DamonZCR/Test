package postgraduate.leetcd.ms;

import java.util.*;
import java.util.stream.Collectors;

/** 微软-MS_MinMoves.jpg
 * 有一个由N个整数组成的数组A，按非递减顺序排列。在一次移动中，你可以从A中移除一个整数，或者在A的任何元素之前或之后插入一个整数。
 * 目标是实现一个数组，其中所有的值X在数组中恰好出现X次。
 * 例如，给定a =[1,1,3,4,4,4]，值1出现两次，值3出现一次，值4出现三次。可以在1和3中分别删除一个匹配项，并插入一个匹配项4，
 * 从而得到数组[1,4,4,4]。在这个数组中，每个元素X正好出现X次。
 *
 * 数组中每个X值出现X次的最小移动次数是多少?
 */
public class MS_MinMoves {
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{1,1,3,4,4,4}));
        System.out.println(solution(new int[]{1,1,1,1,3,3,4,4,4,4,4}));//5
    }
    public static int solution(int[] A){
        int min = 0;
        if (A.length == 0)
            return min;
        List<Integer> ins = Arrays.stream(A).boxed().collect(Collectors.toList());
        ArrayList<Integer> list = new ArrayList<>(ins);
        HashSet<Integer> set = new HashSet<>(ins);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            int fre = Collections.frequency(list, next);
            if (next > fre){
                if ((next - fre) < fre){//说明出现的频率次数多余 需要凑够它（凑够等于nextz值）进行的操作数，所以选择删除。
                    min += next - fre;
                }else if ((next - fre) > fre){//说明出现的频率次数少于 需要凑够它（凑够等于nextz值）进行的操作数，所以选择删除。
                    min += fre;
                }else
                    min += fre;
            }else { // 此时这个值next 小于自己的频率数，那能删除多余出现的次数
                min += fre - next;
            }
        }
        return min;
    }
}
