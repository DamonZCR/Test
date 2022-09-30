package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**20220925闪送
 * 反转链表；
 **/
public class ShanSong_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.substring(1, s.length() - 1).split(",");
        //System.out.println(s1);
        ANode anode;
        ANode pre;
        if (s1.length > 0){
            pre = new ANode();
            pre.val = Integer.parseInt(s1[0]);
        }else
            return;
        ANode last = new ANode();
        last = pre;
        for (int i = 1; i < s1.length; i++) {
            anode = new ANode();
            last.next = anode;
            anode.val = Integer.parseInt(s1[i]);
            last = anode;
        }
        ANode res = ReverseList(pre);
        System.out.print("{");
        for (int i = 0; i < s1.length; i++) {
            System.out.print(res.val);
            res = res.next;
            if (i != s1.length - 1)
                System.out.print(",");
        }
        System.out.println("}");
    }
    public static ANode ReverseList(ANode head){
        ANode preNode = null, next;
        ANode curNode = head;
        while (curNode != null){
            next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }
}
class ANode{
    int val;
    ANode next;
}

