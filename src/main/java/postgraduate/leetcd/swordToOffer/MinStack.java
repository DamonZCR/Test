package postgraduate.leetcd.swordToOffer;

import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 思路：
 * 定义两个栈，A栈用来存储数据，B栈用来存储每存进一个值时，此时的最小数为多少。
 * 那么当A每弹出一个，B也弹出一个，B的栈顶就是弹出后的最小值。
 */
public class MinStack {
    public static void main(String[] args) {
        MinStackMain test = new MinStackMain();
        test.push(1);
        System.out.println(test.min());
        test.push(-7);
        System.out.println(test.min());
        System.out.println(test.top());
        test.pop();
        System.out.println(test.min());
    }
}
class MinStackMain{
    private LinkedList<Integer> one;
    private LinkedList<Integer> two;
    private int min;
    public MinStackMain(){
        one = new LinkedList();
        two = new LinkedList();
        min = Integer.MAX_VALUE;
    }
    public void push(int x){
        one.offer(x);
        if (x < min){
            two.offer(x);
            min = x;
        }else {
            two.offer(min);
        }
    }
    public void pop(){
        one.pollLast();
        two.pollLast();
        if (two.size() != 0)
            min = two.getLast();
        else
            min = Integer.MAX_VALUE;
    }
    public int top(){
        return one.getLast();
    }
    public int min(){
        return min;
    }
}
