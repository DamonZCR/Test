package postgraduate.leetcd.swordToOffer;

import java.util.LinkedList;

/**剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 思路：
 * 1、加入队尾 appendTail()函数： 将数字 val 加入栈 A 即可。
 * 2、删除队首deleteHead()函数： 有以下三种情况。
 *     当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
 *     否则，当 A 为空： 即两个栈都为空，无元素，因此返回 −1。
 *     否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
 */
public class StackToQueue {
    public static void main(String[] args) {
        CQueue dl = new CQueue();
        dl.appendTail(1);
        dl.appendTail(2);
        dl.appendTail(3);
        System.out.println(dl.deleteHead());
        System.out.println(dl.deleteHead());
        System.out.println(dl.deleteHead());
        System.out.println(dl.deleteHead());
    }
}
class CQueue{

    private LinkedList<Integer> one = new LinkedList<Integer>();
    private LinkedList<Integer> two = new LinkedList<Integer>();

    public CQueue(){
    }
    public void appendTail(int value){
        one.offerLast(value);
    }

    /**
     * 这种可以实现更高效率，不用反复进栈入栈，删除的时候线上第二栈去查找，没有在从第一栈中取。
     */
    public int deleteHead(){
        if (two.size() != 0){
            return two.pollLast();
        }else if (one.size() == 0){
            return -1;
        }

        int size = one.size();
        for (int i = 0;i < size - 1;i++){
            two.offerLast(one.pollLast());
        }
        return one.pollLast();
    }

}

