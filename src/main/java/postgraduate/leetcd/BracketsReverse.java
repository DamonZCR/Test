package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**ID 1190反转每对括号间的子串
 * 给出一个字符串s (仅含有小写英文字母和括号)。请你按照从括号内到外的顺序，
 * 逐层反转每对匹配括号中的字符串,并返回最终的结果。注意，您的结果中不应包含任何括号。
 * 示例1:
 * 输入: abcd
 * 输出: dcba
 * 示例2:
 * 输入:u(1ove)i
 * 输出: "iloveu"
 * 示例3:
 * 输入:tel()(((a)))
 * 输出: tela
 */
public class BracketsReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solve(s);
    }
    /**
     * 使用indexQH方法返回本次需要反转括号的位置，再此区间内将区间内的值截取为子list,
     * 然后，将这个子list进行反转，然后在原list中删除这个区间和括号。然后将反转后的list插入
     * 原list中的原位置。
     * @param s
     */
    public static void solve(String s){
        String[] s1 = s.split("");
    ArrayList<String> list = new ArrayList<>(Arrays.asList(s1));
    List<String> lin = new ArrayList<>(list.size());
        while (list.contains("(")){
        int[] ints = indexQH(list);
        if (ints[0] + 1 == ints[0]){
            list.remove(ints[0]);
            list.remove(ints[1]);
            continue;
        }
        lin.addAll(list.subList(ints[0] + 1,ints[1]));
        Collections.reverse(lin);

        for(int i = ints[0];i <= ints[1];i++){
            // 注意：移除时，是对一个位置持续移除，因为移除一个后面的将会补上。
            list.remove(ints[0]);
        }
        list.addAll(ints[0],lin);
        lin.clear();
    }
    String res = "";
    Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
        res += iterator.next();
    }
        System.out.println(res);
}
    /**
     * 一个左括号 ‘(’ 应该对应的 右括号 ‘)’ 是哪一个?
     * 我使用的方法是：记录当遇到右括号‘）’时，最后遇到的左括号‘（’出现的位置，并记录此右括号的位置。
     * 如果右括号的位置大于左括号的位置，就返回这两个记录。
     * @param list
     * @return
     */
    private static int[] indexQH(ArrayList<String> list){
        int[] index = new int[2];
        int lastl = 0;
        int lastr= 0;
        Stack<String> s1 = new Stack<>();
        for(int i = 0;i < list.size();i++){
            if (list.get(i).equals("("))
                lastl = i;
            else if (list.get(i).equals(")"))
                lastr = i;
            if (lastr > lastl){
                index[0] = lastl;
                index[1] = lastr;
                return index;
            }
        }
        return index;
    }
}
