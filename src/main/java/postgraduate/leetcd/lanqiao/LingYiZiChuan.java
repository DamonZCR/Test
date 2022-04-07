package postgraduate.leetcd.lanqiao;

/** 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 * 请按从小到大的顺序输出这32种01串。
 * 解题思路：使用Integer的一个方法，可以将一个整数转为二进制数，由于长度为5的二进制数
 * 最大才是31，所以就是将0到31的数转为二进制然后补够5位就行；
 */
public class LingYiZiChuan {
    public static void main(String[] args) {
        int n = 31;
        // ArrayList<String> list = new ArrayList<>(32);
        StringBuilder sb;
        for (int i = 0; i <= n; i++) {
            sb = new StringBuilder(Integer.toBinaryString(i));
            int len = sb.length();
            if (len < 5){
                for (int j = 0; j < (5 - len); j++) {
                    sb.insert(0,"0");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
