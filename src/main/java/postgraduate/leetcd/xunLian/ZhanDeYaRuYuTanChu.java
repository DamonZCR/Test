package postgraduate.leetcd.xunLian;

import java.util.LinkedList;

/** 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class ZhanDeYaRuYuTanChu {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> link = new LinkedList<Integer>();
        int index1 = 0;// 标记入栈到第几个元素；
        int index2 = 0;// 标记检测到第几个出栈
        int len = popped.length;

        while (index2 != len){
            if (!link.contains(popped[index2])){// 说明栈中不存在这个元素，需要加入；
                // 找到待加入到栈中的元素的下标
                int index = 0;
                for (int i = index1; i < len; i++) {
                    if (pushed[i] == popped[index2]){// 找到
                        index = i;
                        index2++;
                        break;
                    }
                }

                for (int i = index1; i <= index - 1; i++) {
                    link.offer(pushed[i]);
                }
                index1 = index + 1;//此时需要 + 1 跳过这个元素；
                // 不需要将这个元素加入到栈中，因为下一个就是要弹出它；
            }else { // 栈中存在这个元素
                // 栈中如果存在一定是在栈顶，否则说明顺序错误，结束程序；
                if (link.peekLast() == popped[index2]){
                    link.pollLast();
                    index2++;
                }else
                    return false;
            }

        }
        return true;
    }
}
