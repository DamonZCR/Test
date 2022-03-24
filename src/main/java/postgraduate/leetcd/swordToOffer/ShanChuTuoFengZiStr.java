package postgraduate.leetcd.swordToOffer;

import java.util.ArrayList;
import java.util.Scanner;

/**删除字符串中的驼峰子字符串
 * 驼峰子字符串就是第一个和第三个一样，中间的不同；
 * 剩下的字符串中不存在驼峰子字符串；
 * 如输入：yyatae
 * 输出：yye
 * 输入：aaAtaAaAff
 * 输出：aaff
 */
public class ShanChuTuoFengZiStr {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String ab = sc.next();
        for (int i = 0; i < ab.length(); i++) {
            ab = calString(ab);
        }
        System.out.println(ab.toString());
    }
    public static String calString(String s){
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Integer> index = new ArrayList<>();
        if (s.length() < 3)
            return s;
        for (int i = 0; i < s.length() - 2; i++) {
            if(sb.charAt(i) == sb.charAt(i+2) && sb.charAt(i) != sb.charAt(i+1)){
                index.add(i);
                i += 3;

            }
        }
        for (int i = 0; i < index.size(); i++) {
            sb.delete(index.get(i),index.get(i)+3);
        }
        return sb.toString();
    }
}
