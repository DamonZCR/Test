package postgraduate.leetcd.ms;

/** 20220606-兴业数金
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度；
 * 如：“bbbbb”,输出为：1
 * “pareeee”输出为4；
 */
public class XYSJ_ZuiChangBuChongFuZiStr {
    public static void main(String[] args) {
        String s = "pwwkew";
        int[] record = new int[128];
        for(int i = 0; i < 128; i++){
            record[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, record[index] + 1);
            res = Math.max(res, i - start + 1);
            record[index] = i;
        }
        System.out.println(res);
    }
}
