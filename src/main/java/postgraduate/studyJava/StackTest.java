package postgraduate.studyJava;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack 继承自Vector,Vector继承自 List，所以使用栈可以直接使用
 * List代替。
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> ss = new Stack<>();
        Stack<Integer> ss2 = new Stack<>();

        ss.add(22);
        ss.add(23);
        ss2.addAll(ss);
        Iterator it = ss2.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        ss2.insertElementAt(21,1);
        Iterator it2 = ss2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }

}