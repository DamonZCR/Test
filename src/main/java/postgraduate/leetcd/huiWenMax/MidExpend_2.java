package postgraduate.leetcd.huiWenMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**中心扩散法
 * 具体思路在file中的MidExpend.jpg中。
 * 时间复杂度为O(n^2).
 */
public class MidExpend_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try{
            s = br.readLine();
        }catch (IOException e){
            System.out.println(e);
        }

        System.out.println(huiwen(s));
    }
    private static String huiwen(String s){
        if (s.length() <= 1)
            return s;
        String res = s.substring(0,1);
        int maxlen = 1;
        int len = s.length();

        for (int i = 0;i < len - 1;i++){
            String oddstr = valid(s, i, i);
            String evenstr = valid(s, i, i + 1);
            String maxLenStr = oddstr.length() > evenstr.length() ? oddstr : evenstr;
            if (maxLenStr.length() > maxlen) {
                maxlen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String valid(String s, int from, int end){
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数.
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int i = from;
        int j = end;
        int len = s.length();

        while(i >= 0 && j < len){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else
                break;
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }
}
