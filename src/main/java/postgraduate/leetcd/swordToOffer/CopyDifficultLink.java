package postgraduate.leetcd.swordToOffer;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**剑指 Offer 35. 复杂链表的复制
 *请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 这个题目中，每个节点必须重新建立，不能使用引用原有的节点。
 */
class Node35 {
    int val;
    Node35 next;
    Node35 random;

    public Node35(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyDifficultLink {

    public Node35 copyRandomList(Node35 head){
        /**
         * 执行结果：
         * 通过
         * 执行用时：2 ms, 在所有 Java 提交中击败了5.17% 的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了19.54% 的用户
         * 通过测试用例：18 / 18
         * 思路：实例化一个Arraylist: A和HashMap: B.用A存储新生成的每一个节点，遍历给定的链表，遍历的时候顺便把整数值
         * 也存储在A中生成的新节点中，然后同时记录链表每一个节点（此处用的求Hash）和序号，使用B存储，这样做是为了使用节点的
         * random属性时，可以通过random查到它指向的哪一个节点，也就可以B中存储的序号查找到它在A中的位置。
         * 所以在for循环中，首先将A中的节点前后链接，再通过链表中每一个节点的random，在B中找到此random对应
         * 的序号，给当前A的节点找到它需要指的random。
         */
        if (head == null)
            return null;
        LinkedList<Node35> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Node35 nodeNext = head;
        int j = 0;

        while(nodeNext != null){
            Node35 newNode = new Node35(nodeNext.val);
            list.add(newNode);
            map.put(nodeNext.hashCode(), j++);
            nodeNext = nodeNext.next;
        }
        nodeNext = head;
        list.get(list.size()-1).next = null;

        for (int i = 0;i < list.size();i++){
            if (i != list.size() - 1)
                list.get(i).next = list.get(i + 1);
            // 通过链表中对应位置节点的random属性，在map中找到它的random对应序号，使list中的对应节点加上random。
            if (nodeNext.random != null)
                list.get(i).random = list.get(map.get(nodeNext.random.hashCode()));
            else
                list.get(i).random = null;
            nodeNext = nodeNext.next;
        }
        return list.get(0);
    }
    // 官方题解。更容易。
    //只使用一个HashMap即可，Map存放原来链表的节点，值为新的节点，通过原链表某一个节点的random，
    // 查找map中random对应的值（新节点）。
    public Node35 copyRandomList2(Node35 head){
        /**
         * 算法流程：
         *     若头节点 head 为空节点，直接返回 nullnullnull ；
         *     初始化： 哈希表 dic ， 节点 cur 指向头节点；
         *     复制链表：
         *         建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
         *         cur 遍历至原链表下一节点；
         *     构建新链表的引用指向：
         *         构建新节点的 next 和 random 引用指向；
         *         cur 遍历至原链表下一节点；
         *     返回值： 新链表的头节点 dic[cur] ；
         */
        if(head == null) return null;
        Node35 cur = head;
        Map<Node35, Node35> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node35(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

}
